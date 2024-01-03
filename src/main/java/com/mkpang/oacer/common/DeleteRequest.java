package com.mkpang.oacer.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求
 *
 * @author <a href="https://github.com/k9evin">Mingkai Pang</a>
 */
@Data
public class DeleteRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
}