package com.mkpang.oacer.judge;

import com.mkpang.oacer.model.entity.QuestionSubmit;

/**
 * Judge service
 */
public interface JudgeService {

    /**
     * Judge the code
     *
     * @param questionSubmitId The id of the question submit
     * @return The question submit object
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
