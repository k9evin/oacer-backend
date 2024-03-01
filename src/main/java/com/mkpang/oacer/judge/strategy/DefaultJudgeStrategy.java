package com.mkpang.oacer.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.mkpang.oacer.judge.codesandbox.model.JudgeInfo;
import com.mkpang.oacer.model.dto.question.JudgeCase;
import com.mkpang.oacer.model.dto.question.JudgeConfig;
import com.mkpang.oacer.model.entity.Question;
import com.mkpang.oacer.model.enums.JudgeInfoMessageEnum;

import java.util.List;

/**
 * The default strategy for judging a given context.
 */
public class DefaultJudgeStrategy implements JudgeStrategy {

    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        JudgeInfo judgeInfoResponse = new JudgeInfo();
        judgeInfoResponse.setMemory(judgeContext.getJudgeInfo().getMemory());
        judgeInfoResponse.setTime(judgeContext.getJudgeInfo().getTime());

        if (!isOutputSizeValid(judgeContext)) {
            judgeInfoResponse.setMessage(JudgeInfoMessageEnum.WRONG_ANSWER.getValue());
            return judgeInfoResponse;
        }

        if (!isOutputCorrect(judgeContext)) {
            judgeInfoResponse.setMessage(JudgeInfoMessageEnum.WRONG_ANSWER.getValue());
            return judgeInfoResponse;
        }

        Question question = judgeContext.getQuestion();
        JudgeConfig judgeConfig = JSONUtil.toBean(question.getJudgeConfig(), JudgeConfig.class);
        if (!isMemoryLimitValid(judgeInfoResponse.getMemory(), judgeConfig.getMemoryLimit())) {
            judgeInfoResponse.setMessage(JudgeInfoMessageEnum.MEMORY_LIMIT_EXCEEDED.getValue());
            return judgeInfoResponse;
        }

        if (!isTimeLimitValid(judgeInfoResponse.getTime(), judgeConfig.getTimeLimit())) {
            judgeInfoResponse.setMessage(JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED.getValue());
            return judgeInfoResponse;
        }

        judgeInfoResponse.setMessage(JudgeInfoMessageEnum.ACCEPTED.getValue());
        return judgeInfoResponse;
    }

    private boolean isOutputSizeValid(JudgeContext judgeContext) {
        return judgeContext.getOutputList().size() == judgeContext.getInputList().size();
    }

    private boolean isOutputCorrect(JudgeContext judgeContext) {
        List<JudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();
        List<String> outputList = judgeContext.getOutputList();
        for (int i = 0; i < judgeCaseList.size(); i++) {
            if (!judgeCaseList.get(i).getOutput().equals(outputList.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isMemoryLimitValid(Long memory, Long needMemoryLimit) {
        return memory <= needMemoryLimit;
    }

    private boolean isTimeLimitValid(Long time, Long needTimeLimit) {
        return time <= needTimeLimit;
    }
}