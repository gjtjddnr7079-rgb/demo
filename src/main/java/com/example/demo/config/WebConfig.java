package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // [11주차] 단계 2 : 업로드한 파일을 주소로 보여 주는 설정
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**") // 브라우저 요청 주소 : /uploads/파일이름
                .addResourceLocations("file:uploads/"); // 실제 저장 위치 : 프로젝트 루트/uploads/
    }
}