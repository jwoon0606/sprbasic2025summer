package com.thc.sprbasic2025summer.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PostService {

    public Map<String, Object> create(@RequestParam Map<String, Object> param);
    public List<Map<String, Object>> list();
    public Map<String, Object> detail(@PathVariable int id);
    public Map<String, Object> update(@RequestParam Map<String, Object> param);
    public Map<String, Object> delete(int id);
}