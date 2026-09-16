package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    // 기존 hello 맵핑
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "반갑습니다.");
        return "hello";
    }



    

    // [31페이지 연습문제] /hello2 맵핑 및 5개 속성 추가
    @GetMapping("/hello2")
    public String hello2(Model model) {
        // 결과 화면 문구 기준 5가지 속성(Model data) 추가
        model.addAttribute("name", "홍길동님.");
        model.addAttribute("msg1", "방갑습니다.");
        model.addAttribute("msg2", "오늘.");
        model.addAttribute("msg3", "날씨는.");
        model.addAttribute("msg4", "매우 좋습니다.");
        
        return "hello2"; // hello2.html로 이동
    }
}