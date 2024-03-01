package com.mkpang.oacer.judge.codesandbox;

import com.mkpang.oacer.judge.codesandbox.impl.ExampleCodeSandbox;
import com.mkpang.oacer.judge.codesandbox.impl.RemoteCodeSandbox;
import com.mkpang.oacer.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * Code sandbox factory
 */
public class CodeSandboxFactory {

    /**
     * Create a new code sandbox instance based on the type
     *
     * @param type code sandbox type
     * @return new code sandbox instance
     */
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
