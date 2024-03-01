package com.mkpang.oacer.judge.strategy;

import com.mkpang.oacer.judge.codesandbox.model.JudgeInfo;

/**
 * This interface defines the contract for a JudgeStrategy.
 * A JudgeStrategy is responsible for judging a given context.
 */
public interface JudgeStrategy {

    /**
     * This method is responsible for judging a given context.
     *
     * @param judgeContext The context to be judged.
     * @return The result of the judging process, encapsulated in a JudgeInfo object.
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}