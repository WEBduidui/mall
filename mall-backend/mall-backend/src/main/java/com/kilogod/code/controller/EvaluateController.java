package com.kilogod.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.domain.Evaluate;
import com.kilogod.code.domain.dto.EvaluateQueryDTO;
import com.kilogod.code.service.IEvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 评价 前端控制器
 * </p>
 *
 * @author Anding
 */
@Slf4j
@Api(tags = {"评价"})
@RestController
@RequestMapping("/evaluate")
public class EvaluateController {

    @Autowired
    private IEvaluateService evaluateService;


    @PostMapping("/insert")
    @ApiOperation(value = "新增评价")
    public ResultData insert(@RequestBody Evaluate evaluate){
        ResultData rc = new ResultData();
        try {
            rc.setData(evaluateService.insert(evaluate));
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
    @ApiOperation(value = "删除评价")
    public ResultData delete(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(evaluateService.delete(id));
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
    @ApiOperation(value = "更新评价")
    public ResultData update(@RequestBody Evaluate evaluate){
        ResultData rc = new ResultData();
        try {
            rc.setData(evaluateService.updateData(evaluate));
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
    @ApiOperation(value = "查询评价分页数据")
    public ResultData<PageInfo<Evaluate>> getList(EvaluateQueryDTO dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<Evaluate> list = evaluateService.getList(dto);
            PageInfo<Evaluate> data = new PageInfo<>(list);
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
    @ApiOperation(value = "批量删除评价")
    public ResultData batchDelete(@RequestBody List<Integer> ids) {
        ResultData rc = new ResultData();
        try {
            rc.setData(evaluateService.batchDelete(ids));
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
