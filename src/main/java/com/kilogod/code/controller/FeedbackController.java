package com.kilogod.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kilogod.code.common.query.BaseQuery;
import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.config.annotation.validateuser.ValidateUser;
import com.kilogod.code.domain.Feedback;
import com.kilogod.code.domain.vo.UserInfoVO;
import com.kilogod.code.service.IFeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 意见反馈 前端控制器
 * </p>
 *
 * @author Anding
 * @since
 */
@Slf4j
@Api(tags = {"意见反馈"})
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private IFeedbackService feedbackService;


    @PostMapping("/insert")
    @ApiOperation(value = "新增意见反馈")
    public ResultData insert(@RequestBody Feedback feedback, @ValidateUser UserInfoVO vo){
        ResultData rc = new ResultData();
        try {
            if (null==vo.getId()||0==vo.getId()){
                rc.setErrorMsg("提交出错！");
                return rc;
            }
            if (!feedback.getUserId().equals(vo.getId())){
                rc.setErrorMsg("提交出错！");
                return rc;
            }
            rc.setData(feedbackService.insert(feedback));
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
    @ApiOperation(value = "删除意见反馈")
    public ResultData delete(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(feedbackService.delete(id));
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
    @ApiOperation(value = "更新意见反馈")
    public ResultData update(@RequestBody Feedback feedback){
        ResultData rc = new ResultData();
        try {
            rc.setData(feedbackService.updateData(feedback));
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
    @ApiOperation(value = "查询意见反馈分页数据")
    public ResultData<PageInfo<Feedback>> getList(BaseQuery dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<Feedback> list = feedbackService.getList();
            PageInfo<Feedback> data = new PageInfo<>(list);
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
    @ApiOperation(value = "批量删除意见反馈")
    public ResultData batchDelete(@RequestBody List<Integer> ids) {
        ResultData rc = new ResultData();
        try {
            rc.setData(feedbackService.batchDelete(ids));
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
