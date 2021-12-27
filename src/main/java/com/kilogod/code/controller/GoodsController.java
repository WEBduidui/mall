package com.kilogod.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.domain.Goods;
import com.kilogod.code.domain.dto.GoodsQueryDTO;
import com.kilogod.code.service.IGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 商品 前端控制器
 * </p>
 *
 * @author Anding
 * @since
 */
@Slf4j
@Api(tags = {"商品"})
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;


    @PostMapping("/insert")
    @ApiOperation(value = "新增商品")
    public ResultData insert(@RequestBody Goods goods){
        ResultData rc = new ResultData();
        try {
            rc.setData(goodsService.insert(goods));
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
    @ApiOperation(value = "删除商品")
    public ResultData delete(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(goodsService.delete(id));
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
    @ApiOperation(value = "更新商品")
    public ResultData update(@RequestBody Goods goods){
        ResultData rc = new ResultData();
        try {
            rc.setData(goodsService.updateData(goods));
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
    @ApiOperation(value = "查询商品分页数据")
    public ResultData<PageInfo<Goods>> getList(GoodsQueryDTO dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<Goods> list = goodsService.getList(dto);
            PageInfo<Goods> data = new PageInfo<>(list);
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
    @ApiOperation(value = "批量删除商品")
    public ResultData batchDelete(@RequestBody List<Integer> ids) {
        ResultData rc = new ResultData();
        try {
            rc.setData(goodsService.batchDelete(ids));
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
