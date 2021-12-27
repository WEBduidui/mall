package com.kilogod.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.config.annotation.validateuser.ValidateUser;
import com.kilogod.code.domain.TradeSerial;
import com.kilogod.code.domain.dto.TradeSerialQueryDTO;
import com.kilogod.code.domain.vo.UserInfoVO;
import com.kilogod.code.service.ITradeSerialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 交易流水 前端控制器
 * </p>
 *
 * @author Anding
 * @since
 */
@Slf4j
@Api(tags = {"交易流水"})
@RestController
@RequestMapping("/tradeserial")
public class TradeSerialController {

    @Autowired
    private ITradeSerialService tradeSerialService;


    @PostMapping("/insert")
    @ApiOperation(value = "新增交易流水")
    public ResultData insert(@RequestBody TradeSerial tradeSerial){
        ResultData rc = new ResultData();
        try {
            rc.setData(tradeSerialService.insert(tradeSerial));
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
    @ApiOperation(value = "删除交易流水")
    public ResultData delete(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(tradeSerialService.delete(id));
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
    @ApiOperation(value = "更新交易流水")
    public ResultData update(@RequestBody TradeSerial tradeSerial){
        ResultData rc = new ResultData();
        try {
            rc.setData(tradeSerialService.updateData(tradeSerial));
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
    @ApiOperation(value = "查询交易流水分页数据")
    public ResultData<PageInfo<TradeSerial>> getList(TradeSerialQueryDTO dto, @ValidateUser UserInfoVO vo){
        ResultData rc = new ResultData();
        try {
            dto.setUserId(vo.getId());
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<TradeSerial> list = tradeSerialService.getList(dto);
            PageInfo<TradeSerial> data = new PageInfo<>(list);
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

    @GetMapping("/listbyadmin")
    @ApiOperation(value = "查询交易流水分页数据")
    public ResultData<PageInfo<TradeSerial>> getListByAdmin(TradeSerialQueryDTO dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<TradeSerial> list = tradeSerialService.getListByAdmin(dto);
            PageInfo<TradeSerial> data = new PageInfo<>(list);
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
    @ApiOperation(value = "批量删除交易流水")
    public ResultData batchDelete(@RequestBody List<Integer> ids) {
        ResultData rc = new ResultData();
        try {
            rc.setData(tradeSerialService.batchDelete(ids));
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
