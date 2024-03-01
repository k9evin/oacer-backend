package com.mkpang.oacer.judge.codesandbox;

import com.mkpang.oacer.judge.codesandbox.model.ExecuteCodeRequest;
import com.mkpang.oacer.judge.codesandbox.model.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * This class acts as a proxy for the CodeSandbox interface.
 * It logs the request and response information when executing code.
 */
@Slf4j
public class CodeSandboxProxy implements CodeSandbox {

    // The actual implementation of the CodeSandbox interface
    private final CodeSandbox codeSandbox;

    /**
     * Constructor for the CodeSandboxProxy class.
     *
     * @param codeSandbox The actual implementation of the CodeSandbox interface.
     */
    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    /**
     * Executes the code and logs the request and response information.
     *
     * @param executeCodeRequest The request information for executing the code.
     * @return The response information after executing the code.
     */
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱请求信息：" + executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("代码沙箱响应信息：" + executeCodeResponse.toString());
        return executeCodeResponse;
    }
}