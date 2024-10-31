package com.p2p.loan.backend.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response Body 的结构")
public class RespBodyVO<T> implements Serializable {
    private Integer code;//0-失败 1-成功
    private String msg;
    private T data;


    public static <T> RespBodyVO<T> success() {
        return success(null);
    }

    public static <T> RespBodyVO<T> success(T data) {
        return new RespBodyVO<>(1,"OK",data);
    }

    public static <T> RespBodyVO<T> fail() {
        return fail(null);
    }

    public static <T> RespBodyVO<T> fail(T data) {
        return new RespBodyVO<>(0,"FAIL",data);
    }
}
