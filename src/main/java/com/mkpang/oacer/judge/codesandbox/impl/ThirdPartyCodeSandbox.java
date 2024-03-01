package com.mkpang.oacer.judge.codesandbox.impl;

import com.mkpang.oacer.judge.codesandbox.CodeSandbox;
import com.mkpang.oacer.judge.codesandbox.model.ExecuteCodeRequest;
import com.mkpang.oacer.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * Third party code sandbox (using an external service)
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
