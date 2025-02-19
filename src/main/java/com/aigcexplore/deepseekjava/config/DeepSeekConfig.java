package com.aigcexplore.deepseekjava.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * @description
 * @author: RicksonYu
 * @create: 2025年-02月-16日--16:45
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "deepseek.api")  // 绑定 deepseek.api 下的配置
public class DeepSeekConfig {
    private String url;
    private String model;
    private int timeout;


}
