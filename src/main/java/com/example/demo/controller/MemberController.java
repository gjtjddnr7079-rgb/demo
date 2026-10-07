package com.example.demo.controller;

import java.security.Principal;
import com.example.demo.model.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.dto.MemberForm;
import com.example.demo.model.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(MemberForm memberForm, Model model) {
        try {
            memberService.signup(memberForm);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
        return "redirect:/login?signup";
    }

    // MemberController (import java.security.Principal, Member)
    @GetMapping("/mypage") // 내 정보 : 로그인한 사람만
    public String mypage(Principal principal, Model model) { // 현재 로그인 사용자
        Member member = memberService.findByUsername(principal.getName());
        model.addAttribute("member", member);
        return "mypage"; // mypage.html 연결
    }

}