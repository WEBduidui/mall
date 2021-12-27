package com.kilogod.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.config.annotation.validateuser.ValidateUser;
import com.kilogod.code.domain.Shopcart;
import com.kilogod.code.domain.dto.ShopcartQueryDTO;
import com.kilogod.code.domain.vo.UserInfoVO;
import com.kilogod.code.service.IShopcartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 购物车 前端控制器
 * </p>
 *
 * @author Anding
 */
@Slf4j
@Api(tags = {"购物车"})
@RestController
@RequestMapping("/shopcart")
public class ShopcartController {

    @Autowired
    private IShopcartService shopcartService;


    @PostMapping("/insert")
    @ApiOperation(value = "新增购物车")
    public ResultData insert(@RequestBody Shopcart shopcart, @ValidateUser UserInfoVO vo){
        ResultData rc = new ResultData();
        try {
            if (null==vo.getId()||0==vo.getId()){
                rc.setErrorMsg("请先登录！");
                return rc;
            }
            shopcart.setUserId(vo.getId());
            rc.setData(shopcartService.insert(shopcart));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setErrorMsg(e.getMessage());
            e.printStackTrace();
        }
        return rc;
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除购物车")
    public ResultData delete(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(shopcartService.delete(id));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setErrorMsg(e.getMessage());
            e.printStackTrace();
        }
        return rc;
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新购物车")
    public ResultData update(@RequestBody Shopcart shopcart){
        ResultData rc = new ResultData();
        try {
            rc.setData(shopcartService.updateData(shopcart));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setErrorMsg(e.getMessage());
            e.printStackTrace();
        }
        return rc;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询购物车分页数据")
    public ResultData<PageInfo<Shopcart>> getList(ShopcartQueryDTO dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<Shopcart> list = shopcartService.getList(dto);
            PageInfo<Shopcart> data = new PageInfo<>(list);
            rc.setData(data);
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setErrorMsg(e.getMessage());
            e.printStackTrace();
        }
        return rc;
    }

    @PostMapping("/batchDelete")
    @ApiOperation(value = "批量删除购物车")
    public ResultData batchDelete(@RequestBody List<Integer> ids) {
        ResultData rc = new ResultData();
        try {
            rc.setData(shopcartService.batchDelete(ids));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setErrorMsg(e.getMessage());
            e.printStackTrace();
        }
        return rc;
    }

    @PostMapping("/settlement")
    @ApiOperation(value = "结算购物车")
    public ResultData settlement(@RequestBody List<Integer> ids,@ValidateUser UserInfoVO vo) {
        ResultData rc = new ResultData();
        try {
            if (null==vo.getId()||0==vo.getId()){
                rc.setErrorMsg("请先登录！");
                return rc;
            }
            rc.setData(shopcartService.settlement(ids,vo));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setErrorMsg(e.getMessage());
            e.printStackTrace();
        }
        return rc;
    }



}
