package com.thc.sprbasic2025summer.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface BoardService {
    public Map<String,Object> create(Map<String, Object> param);
    public List<Map<String,Object>> list();
    public Map<String,Object> detail(int id);
    public Map<String, Object> update (Map<String, Object> param);
    public Map<String, Object> delete (int id);
}
