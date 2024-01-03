package com.mkpang.oacer.model.dto.question;

import lombok.Data;

/**
 * 判题配置
 *
 * @author <a href="https://github.com/k9evin">Mingkai Pang</a>
 */
@Data
public class JudgeConfig {

    /**
     * 时间限制（ms）
     */
    private Long timeLimit;

    /**
     * 内存限制（KB）
     */
    private Long memoryLimit;

    /**
     * 栈限制（KB）
     */
    private Long stackLimit;


}
