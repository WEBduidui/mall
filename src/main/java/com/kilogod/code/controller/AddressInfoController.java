package com.kilogod.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.config.annotation.validateuser.ValidateUser;
import com.kilogod.code.domain.AddressInfo;
import com.kilogod.code.domain.dto.AddressInfoQueryDTO;
import com.kilogod.code.domain.vo.UserInfoVO;
import com.kilogod.code.service.IAddressInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 客户地址信息 前端控制器
 * </p>
 *
 * @author Anding
 * @since
 */
@Slf4j
@Api(tags = {"客户地址信息"})
@RestController
@RequestMapping("/addressinfo")
public class AddressInfoController {

    @Autowired
    private IAddressInfoService addressInfoService;

    @GetMapping("/getAddressInfo")
    @ApiOperation(value = "获取客户地址信息")
    public ResultData getAddressInfo(@RequestParam String userId){
        ResultData rc = new ResultData();
        try {
            rc.setData(addressInfoService.getAddressInfo(userId));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @PostMapping("/insert")
    @ApiOperation(value = "新增客户地址信息")
    public ResultData insert(@RequestBody AddressInfo addressInfo, @ValidateUser UserInfoVO vo){
        ResultData rc = new ResultData();
        try {
            addressInfo.setUserId(vo.getId());
            rc.setData(addressInfoService.insert(addressInfo));
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
    @ApiOperation(value = "删除客户地址信息")
    public ResultData delete(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(addressInfoService.delete(id));
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
    @ApiOperation(value = "更新客户地址信息")
    public ResultData update(@RequestBody AddressInfo addressInfo){
        ResultData rc = new ResultData();
        try {
            rc.setData(addressInfoService.updateData(addressInfo));
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
    @ApiOperation(value = "查询客户地址信息分页数据")
    public ResultData<PageInfo<AddressInfo>> getList(AddressInfoQueryDTO dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<AddressInfo> list = addressInfoService.getList(dto);
            PageInfo<AddressInfo> data = new PageInfo<>(list);
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
    @ApiOperation(value = "批量删除客户地址信息")
    public ResultData batchDelete(@RequestBody List<Integer> ids) {
        ResultData rc = new ResultData();
        try {
            rc.setData(addressInfoService.batchDelete(ids));
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
