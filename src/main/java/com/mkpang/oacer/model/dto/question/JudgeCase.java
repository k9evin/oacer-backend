package com.mkpang.oacer.model.dto.question;

import lombok.Data;

/**
 * 判题用例
 *
 * @author <a href="https://github.com/k9evin">Mingkai Pang</a>
 */
@Data
public class JudgeCase {

    /**
     * 输入用例
     */
    private String input;

    /**
     * 输出用例
     */
    private String output;
}
