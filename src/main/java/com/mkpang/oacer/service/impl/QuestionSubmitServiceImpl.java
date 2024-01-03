package com.mkpang.oacer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkpang.oacer.common.ErrorCode;
import com.mkpang.oacer.exception.BusinessException;
import com.mkpang.oacer.mapper.QuestionSubmitMapper;
import com.mkpang.oacer.model.dto.questionSubmit.QuestionSubmitRequest;
import com.mkpang.oacer.model.entity.Question;
import com.mkpang.oacer.model.entity.QuestionSubmit;
import com.mkpang.oacer.model.entity.User;
import com.mkpang.oacer.model.enums.QuestionSubmitLanguageEnum;
import com.mkpang.oacer.model.enums.QuestionSubmitStatusEnum;
import com.mkpang.oacer.service.QuestionService;
import com.mkpang.oacer.service.QuestionSubmitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author pangmin
 * @description 针对表【question_submit(题目提交题目)】的数据库操作Service实现
 * @createDate 2023-12-27 22:31:36
 */
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
        implements QuestionSubmitService {

    @Resource
    private QuestionService questionService;

    /**
     * 提交题目
     *
     * @param questionSubmitRequest
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitRequest questionSubmitRequest, User loginUser) {
        String language = questionSubmitRequest.getLanguage();
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if (languageEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "编程语言不合法 (Language Not Valid)");
        }
        Long questionId = questionSubmitRequest.getQuestionId();
        // 判断实体是否存在，根据类别获取实体
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 是否已提交题目
        long userId = loginUser.getId();
        // 每个用户串行提交题目
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setLanguage(language);
        questionSubmit.setCode(questionSubmitRequest.getCode());
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setJudgeInfo("{}");
        boolean save = this.save(questionSubmit);
        if (!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "题目提交失败 (Question Submit Failed)");
        }
        // 提交题目数 + 1
        boolean result = questionService.update()
                .eq("id", questionId)
                .setSql("submitNum = submitNum + 1")
                .update();
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库更新失败 (Database Update Failed)");
        }
        return questionSubmit.getId();
    }
}




