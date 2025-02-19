package com.aigcexplore.deepseekjava.common;

import lombok.Data;

/**
 * @description 通用返回结果
 * @date: 2025年-02月-17日--11:29
 * @author: RicksonYu
 * @create: 2025年-02月-17日--11:29
 */
@Data
public class ApiResponse<T> {

    private int code;
    private String message;
    private T data;

    private ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "Success", data);
    }

    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }
}
