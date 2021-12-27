package com.kilogod.code.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.config.AlipayConfig;
import com.kilogod.code.domain.PayInfo;
import com.kilogod.code.domain.TradeSerial;
import com.kilogod.code.domain.dto.PayInfoDTO;
import com.kilogod.code.domain.dto.PayInfoQueryDTO;
import com.kilogod.code.domain.vo.AlipayTradeCloseVO;
import com.kilogod.code.domain.vo.AlipayTradeQueryVO;
import com.kilogod.code.mapper.PayInfoMapper;
import com.kilogod.code.mapper.TradeSerialMapper;
import com.kilogod.code.mapper.UserMapper;
import com.kilogod.code.service.IPayInfoService;
import com.kilogod.code.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 * 支付订单表 服务实现类
 * </p>
 *
 * @author Anding
 * @since
 */
@Slf4j
@Service
public class PayInfoServiceImpl extends ServiceImpl<PayInfoMapper, PayInfo> implements IPayInfoService {

    @Resource
    private PayInfoMapper mapper;
    @Resource
    private TradeSerialMapper tradeSerialMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public String insert(PayInfoDTO dto) throws ValidationException, UnsupportedEncodingException, AlipayApiException {
        if (dto.getUserId()==null||dto.getUserId()<=0){
            log.error("用户id为空或者为0");
            throw new ValidationException(ResultCode.USER_ID_IS_NOT);
        }
        int i = dto.getTotalAmount().compareTo(BigDecimal.ZERO);
        if (i==0||i==-1){
            log.error("支付金额为空或者为0");
            throw new ValidationException(ResultCode.ORDER_AMOUNT_IS_FAIL);
        }
        PayInfo exPayInfo=new PayInfo();
        exPayInfo.setUserId(dto.getUserId());
        exPayInfo.setTotalAmount(dto.getTotalAmount());

        exPayInfo.setSubject("商城(费用充值)");
        //商家订单号
        String outTradeNo = getOutTradeNo();
        exPayInfo.setBody("商城-"+outTradeNo);
        exPayInfo.setOutTradeNo(outTradeNo);
        exPayInfo.setTradeStatus("WAIT_BUYER_PAY");
        int insert = mapper.insert(exPayInfo);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        log.info("用户："+exPayInfo.getUserId()+",拉起支付");
        String payForm = getPayForm(exPayInfo);
        return payForm;
    }

    /**
     * @Author anding
     *
     * @Param [exPayInfo]
     * @return java.lang.String
     * @Description 返回支付页面
     **/
    private String getPayForm(PayInfo exPayInfo) throws AlipayApiException, UnsupportedEncodingException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no=new String(exPayInfo.getOutTradeNo().getBytes("ISO-8859-1"),"UTF-8");
        //付款金额，必填
        String total_amount=new String(exPayInfo.getTotalAmount().toString().getBytes("ISO-8859-1"),"UTF-8");
        //订单名称，必填
        String subject=new String(exPayInfo.getSubject().getBytes("UTF-8"),"UTF-8");
        //商品描述，可空
        String body=new String(exPayInfo.getBody().getBytes("UTF-8"),"UTF-8");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
//                +"\"timeout_express\":\"2m\"," //订单关闭时间
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\""
//                + ",\"enable_pay_channels\":\"pcredit,moneyFund,debitCardExpress,pcreditpayInstallment\""
//                + ",\"extend_params\":{\"hb_fq_num\":\"3\",\"hb_fq_seller_percent\":\"0\"}"
                + "}");

        //请求
        return alipayClient.pageExecute(alipayRequest).getBody();
    }

    /**
     * 生成支付单号（商家订单号）
     * @return
     */
    public synchronized String getOutTradeNo(){
        Date date=new Date();
        long time = date.getTime();

        String s = DateUtils.formatymdhms.print(LocalDateTime.now())+time;
        log.info("支付单号："+s);
        return s;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<PayInfo>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(PayInfo payInfo) throws ValidationException {
        int i = mapper.updateById(payInfo);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<PayInfo> getList(PayInfoQueryDTO dto) throws ValidationException {
        List<PayInfo> lists = mapper.selectList(new QueryWrapper<PayInfo>()
            .eq(null!=dto.getUserId()&&0!=dto.getUserId(),"user_id",dto.getUserId())
            .eq(StringUtils.isNotBlank(dto.getTradeStatus()),"trade_status",dto.getTradeStatus())
            .like(StringUtils.isNotBlank(dto.getOutTradeNo()),"out_trade_no",dto.getOutTradeNo())
            .like(StringUtils.isNotBlank(dto.getTradeNo()),"trade_no",dto.getTradeNo()));
        if (CollectionUtils.isEmpty(lists)){
            throw new ValidationException(ResultCode.QUERY_IS_NULL);
        }
        return lists;
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
    public int updateByOutTradeNo(PayInfo exPayInfo) throws ValidationException {
        int i = mapper.update(exPayInfo, new QueryWrapper<PayInfo>()
                .eq(StringUtils.isNotBlank(exPayInfo.getOutTradeNo()), "out_trade_no", exPayInfo.getOutTradeNo()));
        if (i<1){
            log.info("支付信息修改失败！支付号："+exPayInfo.getOutTradeNo());
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    /**
     * 支付宝服务器异步通知页面
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     * @throws AlipayApiException
     * @throws ValidationException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public String notifyUrl(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException, ValidationException {
        log.info("支付宝服务器异步通知页面,开始调用");
        Map<String, String> params = getStringStringMap(request,"notify");
        log.info("支付宝服务器异步通知页面参数params:"+params.toString());

        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        log.info("支付宝服务器异步通知页面,调用SDK验证签名:"+signVerified);

        //——请在这里编写您的程序（以下代码仅作参考）——

        /* 实际验证过程建议商户务必添加以下校验：
        1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
        2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
        3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
        4、验证app_id是否为该商户本身。
        */

        //验证成功
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            log.info("异步通知商户订单号："+out_trade_no);

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            log.info("异步通知支付宝交易号："+trade_no);

            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
            log.info("异步通知支付宝交易状态："+trade_status);

            PayInfo exPayInfo=new PayInfo();
            exPayInfo.setTradeStatus(trade_status);
            exPayInfo.setTradeNo(trade_no);
            exPayInfo.setOutTradeNo(out_trade_no);
            exPayInfo.setReceiptAmount(new BigDecimal(new String(request.getParameter("receipt_amount").getBytes("ISO-8859-1"),"UTF-8")));
            exPayInfo.setBuyerPayAmount(new BigDecimal(new String(request.getParameter("buyer_pay_amount").getBytes("ISO-8859-1"),"UTF-8")));
            exPayInfo.setSellerId(new String(request.getParameter("seller_id").getBytes("ISO-8859-1"),"UTF-8"));
            exPayInfo.setFundBillList(new String(request.getParameter("fund_bill_list").getBytes("ISO-8859-1"),"UTF-8"));
            exPayInfo.setBuyerId(new String(request.getParameter("buyer_id").getBytes("ISO-8859-1"),"UTF-8"));
            String gmt_payment = new String(request.getParameter("gmt_payment").getBytes("ISO-8859-1"), "UTF-8");
            log.info("交易付款时间:"+gmt_payment);
            exPayInfo.setSendPayDate(DateUtils.convertStringToDate(gmt_payment,"yyyy-MM-dd HH:mm:ss") );
            updateByOutTradeNo(exPayInfo);

            if(trade_status.equals("TRADE_FINISHED")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知

            }else if (trade_status.equals("TRADE_SUCCESS")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
                PayInfo payInfo = mapper.selectOne(new QueryWrapper<PayInfo>()
                        .eq(StringUtils.isNotBlank(exPayInfo.getOutTradeNo()), "out_trade_no", exPayInfo.getOutTradeNo()));
                if (payInfo==null){
                    log.error("用户："+payInfo.getUserId()+",商户订单号有问题！");
                    throw new ValidationException(ResultCode.OUT_TRADE_NO_ERROR);
                }

                Integer num = tradeSerialMapper.selectCount(new QueryWrapper<TradeSerial>()
                        .eq("trade_no", payInfo.getTradeNo()));
                if (num<1){
                    //记录交易流水
                    TradeSerial exTradeSerial=new TradeSerial();
                    exTradeSerial.setUserId(payInfo.getUserId());
                    exTradeSerial.setTradeNo(payInfo.getTradeNo());
                    exTradeSerial.setAmount(payInfo.getTotalAmount());
                    int exTradeSeriaInsert = tradeSerialMapper.insert(exTradeSerial);
                    if (exTradeSeriaInsert<1){
                        log.error("用户："+payInfo.getUserId()+",交易流水记录出错！");
                        throw new ValidationException(ResultCode.TRADE_SERIAL_CAL_ERROR);
                    }
                    //加储值
                    int updateAmount=userMapper.updateAmount(payInfo.getUserId(),payInfo.getTotalAmount());
                    if (updateAmount<1){
                        log.error("用户:"+payInfo.getUserId()+",金额计算出现错误！");
                        throw new ValidationException(ResultCode.AMOUNT_CAL_ERROR);
                    }
                }
            }

            log.info("支付宝服务器异步通知页面,校验成功!");
            return "success";

        }else {//验证失败
            log.info("支付宝服务器异步通知页面,验证失败!");
            return "fail";

            //调试用，写文本函数记录程序运行情况是否正常
            //String sWord = AlipaySignature.getSignCheckContentV1(params);
            //AlipayConfig.logResult(sWord);
        }
    }

    /**
     * @Author anding
     *
     * @Param [request]
     * @return java.lang.String
     * @Description  支付宝服务器同步通知页面
     **/
    @Override
    public String returnUrl(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
        log.info("支付宝服务器同步通知页面,开始调用");
        Map<String, String> params = getStringStringMap(request,"return");
        log.info("支付宝服务器同步通知页面,参数params:"+params.toString());

        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        log.info("支付宝服务器同步通知页面,调用SDK验证签名:"+signVerified);

        //——请在这里编写您的程序（以下代码仅作参考）——
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            log.info("同步通知商户订单号："+out_trade_no);

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            log.info("同步通知支付宝交易号："+trade_no);

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
            log.info("同步通知付款金额："+total_amount);

            return "<script>window.location.href=\"http://127.0.0.1:8080\"</script>";
        }else {
            log.info("支付宝服务器同步通知页面,验证失败!");
            return "验签失败";
        }
    }

    /**
     * @Author anding
     *
     * @Param [tradeNo, outTradeNo]
     * @return com.kilogod.code.domain.vo.AlipayTradeQueryVO
     * @Description 交易查询
     **/
    @Override
    public AlipayTradeQueryVO tradequery(String tradeNo, String outTradeNo) throws ValidationException,UnsupportedEncodingException, AlipayApiException {

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();

        if (StringUtils.isBlank(tradeNo)&&StringUtils.isBlank(outTradeNo)){
            throw new ValidationException("查询单号不能都为空！");
        }
        if (StringUtils.isBlank(tradeNo)){
            tradeNo="";
        }
        if (StringUtils.isBlank(outTradeNo)){
            outTradeNo="";
        }

        //请二选一设置
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ outTradeNo +"\","+"\"trade_no\":\""+ tradeNo +"\"}");

        //请求
        String result = alipayClient.execute(alipayRequest).getBody();
        log.info("交易查询支付宝返回结果："+result);
        Map parse = (Map) JSON.parse(result);
        Map<String,String> res = (Map) parse.get("alipay_trade_query_response");

        AlipayTradeQueryVO vo=new AlipayTradeQueryVO();
        if ("10000".equals(res.get("code"))&&"Success".equals(res.get("msg"))){
            vo.setBuyer_logon_id(res.get("buyer_logon_id"));
            vo.setBuyer_pay_amount(res.get("buyer_pay_amount"));
            vo.setBuyer_user_id(res.get("buyer_user_id"));
            vo.setBuyer_user_type(res.get("buyer_user_type"));
            vo.setInvoice_amount(res.get("invoice_amount"));
            vo.setOut_trade_no(res.get("out_trade_no"));
            vo.setPoint_amount(res.get("point_amount"));
            vo.setReceipt_amount(res.get("receipt_amount"));
            vo.setSend_pay_date(res.get("send_pay_date"));
            vo.setTotal_amount(res.get("total_amount"));
            vo.setTrade_no(res.get("trade_no"));
            vo.setTrade_status(res.get("trade_status"));
        }else{
            throw new ValidationException(res.get("sub_msg"));
        }
        return vo;
    }

    /**
     * 交易关闭
     * @param tradeNo
     * @param outTradeNo
     * @param operatorId
     * @return
     */
    @Override
    public AlipayTradeCloseVO tradeClose(String tradeNo, String outTradeNo, String operatorId) throws AlipayApiException, ValidationException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradeCloseRequest alipayRequest = new AlipayTradeCloseRequest();
        if (StringUtils.isBlank(tradeNo)&&StringUtils.isBlank(outTradeNo)){
            throw new ValidationException("支付宝订单号和支付商家订单号不能同时为空");
        }
        //商户订单号，商户网站订单系统中唯一订单号
        String out_trade_no = outTradeNo==null?"":outTradeNo;
        //支付宝交易号
        String trade_no = tradeNo==null?"":tradeNo;
        //操作人员
        String operator_id=operatorId==null?"":operatorId;
        //请二选一设置

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                +"\"trade_no\":\""+ trade_no +"\"," +
                "\"operator_id\":\""+operator_id+"\"}");

        //请求
        String result = alipayClient.execute(alipayRequest).getBody();
        log.info("交易查询支付宝返回结果："+result);
        Map parse = (Map) JSON.parse(result);
        Map<String,String> res = (Map) parse.get("alipay_trade_close_response");

        AlipayTradeCloseVO vo=new AlipayTradeCloseVO();
        if ("10000".equals(res.get("code"))&&"Success".equals(res.get("msg"))){
            vo.setOut_trade_no(res.get("out_trade_no"));
            vo.setTrade_no(res.get("trade_no"));
            PayInfo exPayInfo=new PayInfo();
            exPayInfo.setTradeStatus("TRADE_CLOSED");
            int update = mapper.update(exPayInfo, new QueryWrapper<PayInfo>().eq("out_trade_no", res.get("out_trade_no")));
            if (update<1){
                throw new ValidationException("支付订单状态修改失败！");
            }
        }else{
            throw new ValidationException(res.get("sub_msg"));
        }
        return vo;
    }


    private Map<String, String> getStringStringMap(HttpServletRequest request, String type) throws UnsupportedEncodingException {
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        log.info("支付宝"+("return".equals(type)?"同步":"异步")+"回调参数："+ JSONObject.toJSONString(requestParams));
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            if ("return".equals(type)){
                //乱码解决，这段代码在出现乱码时使用
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            }
            params.put(name, valueStr);
        }
        return params;
    }
}
