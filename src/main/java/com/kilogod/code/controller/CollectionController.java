package com.kilogod.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.config.annotation.validateuser.ValidateUser;
import com.kilogod.code.domain.Collection;
import com.kilogod.code.domain.dto.CollectionQueryDTO;
import com.kilogod.code.domain.vo.UserInfoVO;
import com.kilogod.code.service.ICollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 收藏 前端控制器
 * </p>
 *
 * @author Anding
 */
@Slf4j
@Api(tags = {"收藏"})
@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private ICollectionService collectionService;


    @PostMapping("/insert")
    @ApiOperation(value = "新增收藏")
    public ResultData insert(@RequestBody Collection collection, @ValidateUser UserInfoVO vo){
        ResultData rc = new ResultData();
        try {
            if (null==vo.getId()||0==vo.getId()){
                rc.setErrorMsg("请先登录！");
                return rc;
            }
            collection.setUserId(vo.getId());
            rc.setData(collectionService.insert(collection));
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
    @ApiOperation(value = "删除收藏")
    public ResultData delete(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(collectionService.delete(id));
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
    @ApiOperation(value = "更新收藏")
    public ResultData update(@RequestBody Collection collection){
        ResultData rc = new ResultData();
        try {
            rc.setData(collectionService.updateData(collection));
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
    @ApiOperation(value = "查询收藏分页数据")
    public ResultData<PageInfo<Collection>> getList(CollectionQueryDTO dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<Collection> list = collectionService.getList(dto);
            PageInfo<Collection> data = new PageInfo<>(list);
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
    @ApiOperation(value = "批量删除收藏")
    public ResultData batchDelete(@RequestBody List<Integer> ids) {
        ResultData rc = new ResultData();
        try {
            rc.setData(collectionService.batchDelete(ids));
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
