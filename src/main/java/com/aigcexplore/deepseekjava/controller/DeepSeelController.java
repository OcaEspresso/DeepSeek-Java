package com.aigcexplore.deepseekjava.controller;

import com.aigcexplore.deepseekjava.common.ApiResponse;
import com.aigcexplore.deepseekjava.service.DeepSeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @author: RicksonYu
 * @create: 2025年-02月-17日--11:14
 */
@CrossOrigin(origins = "http://localhost:5173")  // 允许前端访问
@RestController
@RequestMapping("/deepseek")
public class DeepSeelController {

    @Autowired
    private DeepSeekService deepSeekService;

    @GetMapping("/chat")
    @ResponseBody
    public ApiResponse<String> chat(@RequestParam String prompt) {

        return deepSeekService.chatWithAI(prompt); // 这里不需要再转换，因为 service 已经返回 JSON

    }

}
