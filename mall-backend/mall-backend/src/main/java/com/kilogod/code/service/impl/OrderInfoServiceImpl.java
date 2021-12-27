package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.*;
import com.kilogod.code.domain.dto.OrderQueryDTO;
import com.kilogod.code.domain.vo.AnalysisVO;
import com.kilogod.code.domain.vo.OrderInfoVO;
import com.kilogod.code.domain.vo.OrderanalysisVO;
import com.kilogod.code.domain.vo.TypeanalysisVO;
import com.kilogod.code.mapper.*;
import com.kilogod.code.service.IGoodsService;
import com.kilogod.code.service.IOrderInfoService;
import com.kilogod.code.service.ISmsInfoService;
import com.kilogod.code.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author Anding
 * @since
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    @Resource
    private OrderInfoMapper mapper;

    @Resource
    private TradeSerialMapper tradeSerialMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private IntegralRecordMapper recordMapper;

    @Resource
    private ISmsInfoService smsInfoService;
    @Autowired
    private IGoodsService goodsService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(OrderInfo order) throws ValidationException {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", order.getUserId()));
        if (user==null){
            throw new ValidationException(ResultCode.USER_ID_IS_NOT);
        }
        Goods goods = goodsMapper.selectOne(new QueryWrapper<Goods>().eq("shop_id", order.getShopId()));
        if (goods==null){
            throw new ValidationException(ResultCode.QUERY_FAIL);
        }
        if (user.getAmount().compareTo(goods.getPrice())==-1){
            throw new ValidationException(ResultCode.BALANCE_NOT_ENOUGH);
        }
        String orderId = generatorOrderId();
        TradeSerial tradeSerial=new TradeSerial();
        tradeSerial.setAmount(goods.getPrice());
        tradeSerial.setOrderId(orderId);
        tradeSerial.setUserId(user.getId());
        //记录流水
        int insert1 = tradeSerialMapper.insert(tradeSerial);
        if (insert1 < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        //记录积分
        IntegralRecord record=new IntegralRecord();
        record.setUserId(user.getId());
        record.setOrderId(orderId);
        record.setAmount(goods.getPrice());
        int integral = goods.getPrice().intValue();
        record.setIntegral(integral);
        int recordInsert = recordMapper.insert(record);
        if (recordInsert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }

        //减储值金额 加积分
        int nowintegral = user.getIntegral() + integral;
        user.setIntegral(nowintegral);
        if (nowintegral>1000){
            user.setIsVip("2");
        }else if (nowintegral>3000){
            user.setIsVip("3");
        }else if (nowintegral>5000){
            user.setIsVip("4");
        }else if (nowintegral>10000){
            user.setIsVip("5");
        }else if (nowintegral>20000){
            user.setIsVip("6");
        }
        user.setAmount(user.getAmount().subtract(goods.getPrice()));
        int update = userMapper.updateById(user);
        if (update < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        order.setOrderId(orderId);
        order.setStatus("1");
        //新增订单
        int insert = mapper.insert(order);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }

        //修改商品销量
        goods.setSales(goods.getSales()+1);
        goodsMapper.updateById(goods);

        return insert;
    }

    public synchronized String generatorOrderId() throws ValidationException {
        return DateUtils.formatymdhmss.print(LocalDateTime.now());
    }
    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<OrderInfo>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(OrderInfo order) throws ValidationException {
//        if ("4".equals(order.getStatus())){
//            //发短信
//            User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", order.getUserId()));
//            SmsNameInfoDTO dto=new SmsNameInfoDTO();
//            dto.setPhone(user.getPhone());
//            dto.setTemplateCode("SMS_205139554");
//            dto.setTemplateParam("code");
//            smsInfoService.sendSmsName(dto);
//        }
        int i = mapper.updateById(order);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<OrderInfo> getList(OrderQueryDTO dto) throws ValidationException {
        List<OrderInfo> lists = mapper.selectList(new QueryWrapper<OrderInfo>()
                .eq(StringUtils.isNotBlank(dto.getOrderId()),"order_id",dto.getOrderId())
                .eq(StringUtils.isNotBlank(dto.getStatus()),"status",dto.getStatus())
                .eq(dto.getUserId()!=null,"user_id",dto.getUserId())
                .orderByDesc("create_time"));
        if (CollectionUtils.isEmpty(lists)){
            throw new ValidationException(ResultCode.QUERY_IS_NULL);
        }
        return lists;
    }

    @Override
    public List<OrderInfoVO> listAndGoods(OrderQueryDTO dto) throws ValidationException {
        List<OrderInfo> lists = mapper.selectList(new QueryWrapper<OrderInfo>()
                .eq(StringUtils.isNotBlank(dto.getOrderId()),"order_id",dto.getOrderId())
                .eq(StringUtils.isNotBlank(dto.getStatus()),"status",dto.getStatus())
                .eq(dto.getUserId()!=null,"user_id",dto.getUserId())
                .orderByDesc("create_time"));
        List<OrderInfoVO> vos=new ArrayList<>();
        for (OrderInfo list : lists) {
            OrderInfoVO vo=new OrderInfoVO();
            BeanUtils.copyProperties(list, vo);
            Goods goods = goodsService.getOne(new QueryWrapper<Goods>().eq("shop_id", list.getShopId()));
            if (null!=goods){
                vo.setGoods(goods);
            }
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public int batchDelete(List<Integer> ids) throws ValidationException {
        int i = mapper.deleteBatchIds(ids);
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public List<OrderanalysisVO> orderanalysis() throws ValidationException {
        return mapper.orderanalysis();
    }

    @Override
    public TypeanalysisVO typeanalysis() throws ValidationException {
        List<AnalysisVO> typeanalysis = mapper.typeanalysis();
        List<String> types=new ArrayList<>();
        for (AnalysisVO vo : typeanalysis) {
            types.add(vo.getName());
        }

        TypeanalysisVO vo=new TypeanalysisVO();
        vo.setData(typeanalysis);
        vo.setType(types);
        return vo;
    }
}
