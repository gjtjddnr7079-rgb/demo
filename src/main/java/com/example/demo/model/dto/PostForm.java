package com.example.demo.model.dto;

import lombok.Data;

@Data
public class PostForm { // 글쓰기·수정화면→ 컨트롤러로전달되는데이터(DTO)
    private String title; // 제목(input name="title")
    private String content; // 내용(textarea name="content")
    // 작성자는받지않는다→ 로그인한사람으로서버가정한다
}