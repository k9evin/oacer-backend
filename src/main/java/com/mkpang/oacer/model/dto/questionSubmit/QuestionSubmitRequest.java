package com.mkpang.oacer.model.dto.questionSubmit;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/k9evin">Mingkai Pang</a>
 */
@Data
public class QuestionSubmitRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 编程语言
     */
    private String language;
    /**
     * 用户代码
     */
    private String code;
    /**
     * 题目 id
     */
    private Long questionId;
}