package com.example.demo.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.service.CommentService;

@Controller
@RequestMapping("/board/{postId}/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public String write(@PathVariable Long postId,
                        @RequestParam(defaultValue = "") String content,
                        Principal principal) {
        try {
            commentService.write(postId, content, principal.getName());
            return "redirect:/board/" + postId + "#comments";
        } catch (IllegalArgumentException e) {
            return "redirect:/board/" + postId + "?commentError#comments";
        }
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long postId, @PathVariable Long id) {
        commentService.delete(id);
        return "redirect:/board/" + postId + "?commentDeleted#comments";
    }
}