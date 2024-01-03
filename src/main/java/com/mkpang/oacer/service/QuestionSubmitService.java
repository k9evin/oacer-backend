package com.mkpang.oacer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mkpang.oacer.model.dto.questionSubmit.QuestionSubmitRequest;
import com.mkpang.oacer.model.entity.QuestionSubmit;
import com.mkpang.oacer.model.entity.User;

/**
 * @author pangmin
 * @description 针对表【question_submit(题目提交)】的数据库操作Service
 * @createDate 2023-12-27 22:31:36
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitRequest questionSubmitRequest, User loginUser);
}
