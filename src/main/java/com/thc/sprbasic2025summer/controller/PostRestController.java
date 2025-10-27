package com.thc.sprbasic2025summer.controller;

import com.thc.sprbasic2025summer.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/post")
@RestController
public class PostRestController {

    final PostService postService;

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> param) {
        return postService.create(param);
    }

    @GetMapping("/list")
    public List<Map<String,Object>> list() {
        return postService.list();
    }

    @GetMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable int id) {
        return postService.detail(id);
    }

    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> param) {
        return postService.update(param);
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(int id) {
        return postService.delete(id);
    }
}
