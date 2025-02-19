package com.aigcexplore.deepseekjava.service.impl;

import com.aigcexplore.deepseekjava.common.ApiResponse;
import com.aigcexplore.deepseekjava.config.DeepSeekConfig;
import com.aigcexplore.deepseekjava.service.DeepSeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @description
 * @author: RicksonYu
 * @create: 2025年-02月-16日--15:24
 */
@Service
public class DeepSeekServiceImpl implements DeepSeekService {

   private final DeepSeekConfig deepSeekConfig;

    private final RestTemplate restTemplate;

    public DeepSeekServiceImpl(RestTemplate restTemplate,DeepSeekConfig deepSeekConfig) {
        this.restTemplate = restTemplate;
        this.deepSeekConfig=deepSeekConfig;
    }

    @Override
    public ApiResponse<String>  chatWithAI(String prompt) {

        // 构造请求体
        Map<String, Object> requestBody = buildRequestBody(prompt);

        try{
            // 发送请求并获取返回值
            Map response = restTemplate.postForObject(deepSeekConfig.getUrl(), requestBody, Map.class);
            // 解析返回内容，使用 Optional 避免 NullPointerException
            String result = Optional.ofNullable(response)
                    .map(res -> res.get("response"))
                    .map(Object::toString)
                    .orElse("Error: No valid response from DeepSeek");

            return ApiResponse.success(result); // 返回 JSON 结构的数据

        }catch (RestClientException e)
        {
            return ApiResponse.error(502, "Failed to connect to DeepSeek API - " + e.getMessage());
        }



    }

    /**
     * 构造 DeepSeek 请求 JSON
     */
    private Map<String, Object> buildRequestBody(String prompt) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", deepSeekConfig.getModel()); // 从配置文件读取模型
        requestBody.put("prompt", prompt);
        requestBody.put("stream", false);
        return requestBody;
    }

}
