package com.mkpang.oacer.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文件上传业务类型枚举
 *
 * @author <a href="https://github.com/k9evin">Mingkai Pang</a>
 */
public enum JudgeInfoMessageEnum {

    ACCEPTED("通过 (Accepted)", "Accepted"),
    WRONG_ANSWER("答案错误 (Wrong Answer)", "Wrong Answer"),
    COMPILE_ERROR("编译错误 (Compile Error)", "Compile Error"),
    MEMORY_LIMIT_EXCEEDED("内存超限 (Memory Limit Exceeded)", "Memory Limit Exceeded"),
    TIME_LIMIT_EXCEEDED("时间超限 (Time Limit Exceeded)", "Time Limit Exceeded"),
    PRESENTATION_ERROR("格式错误 (Presentation Error)", "Presentation Error"),
    OUTPUT_LIMIT_EXCEEDED("输出超限 (Output Limit Exceeded)", "Output Limit Exceeded"),
    DANGEROUS_OPERATION("危险操作 (Dangerous Operation)", "Dangerous Operation"),
    RUNTIME_ERROR("运行时错误 (Runtime Error)", "Runtime Error"),
    SYSTEM_ERROR("系统错误 (System Error)", "System Error"),
    WAITING("等待中 (Waiting)", "Waiting");

    private final String text;

    private final String value;

    JudgeInfoMessageEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static JudgeInfoMessageEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoMessageEnum anEnum : JudgeInfoMessageEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
