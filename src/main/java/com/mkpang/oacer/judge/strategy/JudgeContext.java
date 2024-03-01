package com.mkpang.oacer.judge.strategy;

import com.mkpang.oacer.judge.codesandbox.model.JudgeInfo;
import com.mkpang.oacer.model.dto.question.JudgeCase;
import com.mkpang.oacer.model.entity.Question;
import com.mkpang.oacer.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
