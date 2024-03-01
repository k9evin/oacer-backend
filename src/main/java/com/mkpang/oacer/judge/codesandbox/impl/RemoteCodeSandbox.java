package com.mkpang.oacer.judge.codesandbox.impl;

import com.mkpang.oacer.judge.codesandbox.CodeSandbox;
import com.mkpang.oacer.judge.codesandbox.model.ExecuteCodeRequest;
import com.mkpang.oacer.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * Remote code sandbox (internal service)
 */
public class RemoteCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        return null;
    }
}
