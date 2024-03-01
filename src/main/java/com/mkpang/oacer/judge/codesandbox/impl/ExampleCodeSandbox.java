package com.mkpang.oacer.judge.codesandbox.impl;

import com.mkpang.oacer.judge.codesandbox.CodeSandbox;
import com.mkpang.oacer.judge.codesandbox.model.ExecuteCodeRequest;
import com.mkpang.oacer.judge.codesandbox.model.ExecuteCodeResponse;
import com.mkpang.oacer.judge.codesandbox.model.JudgeInfo;
import com.mkpang.oacer.model.enums.JudgeInfoMessageEnum;
import com.mkpang.oacer.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * This class is an implementation of the CodeSandbox interface.
 * It is used for testing purposes and simulates the execution of code.
 */
public class ExampleCodeSandbox implements CodeSandbox {

    /**
     * This method simulates the execution of code.
     *
     * @param executeCodeRequest The request object
     * @return The response object containing the results of the code execution.
     */
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行代码成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);

        return executeCodeResponse;
    }
}
