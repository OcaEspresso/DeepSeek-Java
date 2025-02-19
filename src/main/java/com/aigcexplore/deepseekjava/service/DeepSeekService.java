package com.aigcexplore.deepseekjava.service;

import com.aigcexplore.deepseekjava.common.ApiResponse;

/**
 * @description
 * @author: RicksonYu
 * @create: 2025年-02月-16日--15:23
 */
public interface DeepSeekService {

    /**
     * 发送请求到DeepSeek 7B  ,  并返回AI的回答
     * @param prompt 用户输入
     * @return 通用AI回复  - 目前调用deepseek与 chatgpt
     * **/

    ApiResponse<String> chatWithAI(String prompt);

}
