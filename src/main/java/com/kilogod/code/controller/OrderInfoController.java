package com.kilogod.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.config.annotation.validateuser.ValidateUser;
import com.kilogod.code.domain.OrderInfo;
import com.kilogod.code.domain.dto.OrderQueryDTO;
import com.kilogod.code.domain.vo.OrderInfoVO;
import com.kilogod.code.domain.vo.UserInfoVO;
import com.kilogod.code.service.IOrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author Anding
 * @since
 */
@Slf4j
@Api(tags = {"订单"})
@RestController
@RequestMapping("/order")
public class OrderInfoController {

    @Autowired
    private IOrderInfoService orderService;


    @PostMapping("/insert")
    @ApiOperation(value = "新增订单")
    public ResultData insert(@RequestBody OrderInfo order, @ValidateUser UserInfoVO userInfoVO){
        ResultData rc = new ResultData();
        try {
            order.setUserId(userInfoVO.getId());
            rc.setData(orderService.insert(order));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除订单")
    public ResultData delete(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(orderService.delete(id));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新订单")
    public ResultData update(@RequestBody OrderInfo order){
        ResultData rc = new ResultData();
        try {
            rc.setData(orderService.updateData(order));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询订单分页数据")
    public ResultData<PageInfo<OrderInfo>> getList(OrderQueryDTO dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<OrderInfo> list = orderService.getList(dto);
            PageInfo<OrderInfo> data = new PageInfo<>(list);
            rc.setData(data);
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @GetMapping("/listAndGoods")
    @ApiOperation(value = "查询订单及商品信息")
    public ResultData<PageInfo<OrderInfoVO>> listAndGoods(OrderQueryDTO dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<OrderInfoVO> list = orderService.listAndGoods(dto);
            PageInfo<OrderInfoVO> data = new PageInfo<>(list);
            rc.setData(data);
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }



    @PostMapping("/batchDelete")
    @ApiOperation(value = "批量删除订单")
    public ResultData batchDelete(@RequestBody List<Integer> ids) {
        ResultData rc = new ResultData();
        try {
            rc.setData(orderService.batchDelete(ids));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @GetMapping("/orderanalysis")
    @ApiOperation(value = "订单数据")
    public ResultData orderanalysis() {
        ResultData rc = new ResultData();
        try {
            rc.setData(orderService.orderanalysis());
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @GetMapping("/typeanalysis")
    @ApiOperation(value = "商品分类数据")
    public ResultData typeanalysis() {
        ResultData rc = new ResultData();
        try {
            rc.setData(orderService.typeanalysis());
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }


}
