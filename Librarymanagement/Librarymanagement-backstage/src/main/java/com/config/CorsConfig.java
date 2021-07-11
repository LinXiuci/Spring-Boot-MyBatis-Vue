package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//配置类
public class CorsConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //.allowedOrigins("*") //.allowCredentials() 当true时 改为.allowedOriginPatterns("*")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")//支持的HTTP请求方法集合（必须全部是大写）
                /**
                 * 设置是否发送凭证，该值是在预请求的响应的“Access-Control-Max-Age”上设置的。该值决定在发起跨域请求时，浏览器是否需要发送凭证。
                 * false　　—　　cookies不应该包括在内；
                 * ""　　　 —　　意味着未定义，允许所有值；
                 * true　　 —　　预响应将包括值设置为true的报头Access-Control-Allow-Credentials
                 *  */ 
                .allowCredentials(true)
                .maxAge(3600)   //预响应缓存的最大持续时间，单位秒
                .allowedHeaders("*");   //在实际请求中允许的请求头列表，“*”表示允许所有的headers
    }

}

