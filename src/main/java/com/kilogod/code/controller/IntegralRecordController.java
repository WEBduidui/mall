package com.kilogod.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.domain.IntegralRecord;
import com.kilogod.code.domain.dto.IntegralRecordQueryDTO;
import com.kilogod.code.service.IIntegralRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 积分记录 前端控制器
 * </p>
 *
 * @author Anding
 * @since
 */
@Slf4j
@Api(tags = {"积分记录"})
@RestController
@RequestMapping("/integralrecord")
public class IntegralRecordController {

    @Autowired
    private IIntegralRecordService integralRecordService;


    @PostMapping("/insert")
    @ApiOperation(value = "新增积分记录")
    public ResultData insert(@RequestBody IntegralRecord integralRecord){
        ResultData rc = new ResultData();
        try {
            rc.setData(integralRecordService.insert(integralRecord));
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
    @ApiOperation(value = "删除积分记录")
    public ResultData delete(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(integralRecordService.delete(id));
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
    @ApiOperation(value = "更新积分记录")
    public ResultData update(@RequestBody IntegralRecord integralRecord){
        ResultData rc = new ResultData();
        try {
            rc.setData(integralRecordService.updateData(integralRecord));
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
    @ApiOperation(value = "查询积分记录分页数据")
    public ResultData<PageInfo<IntegralRecord>> getList(IntegralRecordQueryDTO dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<IntegralRecord> list = integralRecordService.getList(dto);
            PageInfo<IntegralRecord> data = new PageInfo<>(list);
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
    @ApiOperation(value = "批量删除积分记录")
    public ResultData batchDelete(@RequestBody List<Integer> ids) {
        ResultData rc = new ResultData();
        try {
            rc.setData(integralRecordService.batchDelete(ids));
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
