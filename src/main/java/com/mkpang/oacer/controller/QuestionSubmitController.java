package com.mkpang.oacer.controller;

import com.mkpang.oacer.common.BaseResponse;
import com.mkpang.oacer.common.ErrorCode;
import com.mkpang.oacer.common.ResultUtils;
import com.mkpang.oacer.exception.BusinessException;
import com.mkpang.oacer.model.dto.questionSubmit.QuestionSubmitRequest;
import com.mkpang.oacer.model.entity.User;
import com.mkpang.oacer.service.QuestionSubmitService;
import com.mkpang.oacer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author <a href="https://github.com/k9evin">Mingkai Pang</a>
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitRequest
     * @param request
     * @return submi
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitRequest questionSubmitRequest,
                                               HttpServletRequest request) {
        if (questionSubmitRequest == null || questionSubmitRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        int questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

}
