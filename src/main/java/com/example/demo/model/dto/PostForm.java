package com.example.demo.model.dto;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PostForm {
    private String title;
    private String content;

    // [11주차] 단계 1 : 모집 인원 (input name="capacity", 비우면 null = 일반 글)
    private Integer capacity;

    // [11주차] 단계 2 : 포스터 이미지 (input type="file" name="poster")
    private MultipartFile poster;
}