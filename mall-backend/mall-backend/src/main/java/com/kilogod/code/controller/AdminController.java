package com.kilogod.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kilogod.code.common.query.BaseQuery;
import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.domain.Admin;
import com.kilogod.code.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author Anding
 * @since
 */
@Slf4j
@Api(tags = {"管理员"})
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;


    @PostMapping("/insert")
    @ApiOperation(value = "新增管理员")
    public ResultData insert(@RequestBody Admin admin){
        ResultData rc = new ResultData();
        try {
            rc.setData(adminService.insert(admin));
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
    @ApiOperation(value = "删除管理员")
    public ResultData delete(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(adminService.delete(id));
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
    @ApiOperation(value = "更新管理员")
    public ResultData update(@RequestBody Admin admin){
        ResultData rc = new ResultData();
        try {
            rc.setData(adminService.updateData(admin));
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
    @ApiOperation(value = "查询管理员分页数据")
    public ResultData<PageInfo<Admin>> getList(BaseQuery dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<Admin> list = adminService.getList();
            PageInfo<Admin> data = new PageInfo<>(list);
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
    @ApiOperation(value = "批量删除管理员")
    public ResultData batchDelete(@RequestBody List<Integer> ids) {
        ResultData rc = new ResultData();
        try {
            rc.setData(adminService.batchDelete(ids));
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
