package com.mkpang.oacer.model.dto.questionSubmit;

import com.mkpang.oacer.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 创建查询请求
 *
 * @author <a href="https://github.com/k9evin">Mingkai Pang</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 编程语言
     */
    private String language;

    /**
     * 提交状态（0-未判题，1-判题中，2-成功，3-失败）
     */
    private Integer status;

    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 用户 id
     */
    private Long userId;
}