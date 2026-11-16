package com.example.demo.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.domain.Post;
import com.example.demo.model.dto.PostForm;
import com.example.demo.model.service.CommentService;
import com.example.demo.model.service.PostService;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

   // [연습문제 2 반영] 목록 + 페이징 + 검색 범위(type)
    @GetMapping
    public String list(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "title") String type,
                       @RequestParam(required = false) String keyword,
                       Model model) {
        Page<Post> posts = postService.findPage(type, keyword, page);
        model.addAttribute("posts", posts.getContent());
        model.addAttribute("page", posts);
        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        return "board/list";
    }

    // [연습문제 1 반영] 내가 쓴 글 페이징 (GET /board/my?page=0)
    @GetMapping("/my")
    public String myPosts(@RequestParam(defaultValue = "0") int page,
                          Principal principal,
                          Model model) {
        Page<Post> posts = postService.findMyPage(principal.getName(), page);
        model.addAttribute("posts", posts.getContent());
        model.addAttribute("page", posts);
        model.addAttribute("pageUrl", "/board/my");
        model.addAttribute("listTitle", "내가 쓴 글");
        return "board/list";
    }

    @GetMapping("/write")
    public String writeForm() {
        return "board/form";
    }

    @PostMapping("/write")
    public String write(PostForm postForm, Principal principal, Model model) {
        try {
            Post post = postService.write(postForm, principal.getName());
            return "redirect:/board/" + post.getId();
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "board/form";
        }
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Post post = postService.read(id);
        model.addAttribute("post", post);
        model.addAttribute("comments", commentService.findByPost(post));
        return "board/detail";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Post post = postService.findForEdit(id);
        PostForm postForm = new PostForm();
        postForm.setTitle(post.getTitle());
        postForm.setContent(post.getContent());
        model.addAttribute("postForm", postForm);
        model.addAttribute("postId", id);
        return "board/form";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, PostForm postForm, Model model) {
        try {
            postService.edit(id, postForm);
            return "redirect:/board/" + id;
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("postId", id);
            return "board/form";
        }
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        postService.delete(id);
        return "redirect:/board?deleted";
    }
}