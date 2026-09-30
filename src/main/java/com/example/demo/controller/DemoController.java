package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.example.demo.model.domain.TestDB;
import com.example.demo.model.service.TestService; // 최상단 서비스 클래스 연동 추가

@Controller
public class DemoController {

    @Autowired
    TestService testService; // DemoController

    // 기존 hello 맵핑
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "반갑습니다.");
        return "hello";
    }

    // @GetMapping("/testdb")
    // public String getAllTestDBs(Model model) {
    // TestDB test = testService.findByName("홍길동");
    // model.addAttribute("data4", test);
    // System.out.println("데이터 출력 디버그 : " + test);
    // return "testdb";
    // }

    @GetMapping("/testdb")
    public String getAllTestDBs(Model model) {
        // 단일 조회 대신 findAll()을 사용하여 전체 리스트를 가져옵니다.
        List<TestDB> users = testService.findAll();
        model.addAttribute("users", users);

        return "testdb";
    }

}