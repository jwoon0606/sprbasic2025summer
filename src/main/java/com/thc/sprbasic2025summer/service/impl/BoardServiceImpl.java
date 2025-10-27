package com.thc.sprbasic2025summer.service.impl;

import com.thc.sprbasic2025summer.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    List<Map<String,Object>> list = new ArrayList<>();
    int tempId = 0;

    @Override
    public Map<String, Object> create(Map<String, Object> param) {
        String title = String.valueOf(param.get("title"));
        String content = String.valueOf(param.get("content"));
        String author = String.valueOf(param.get("author"));
        Map<String, Object> map_board = new HashMap<>();
        map_board.put("id", ++tempId);
        map_board.put("title", title);
        map_board.put("content", content);
        map_board.put("author", author);
        list.add(map_board);

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("result", 200);
        map_result.put("totalsize", list.size());

        return map_result;
    }

    @Override
    public List<Map<String, Object>> list() {
        return list;
    }

    @Override
    public Map<String, Object> detail(int id) {
        Map<String, Object> map_board = getBoard(id);

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("result",200);
        map_result.put("board",map_board);

        return map_result;
    }

    @Override
    public Map<String, Object> update(Map<String, Object> param) {
        Map<String, Object> map_board = getBoard(Integer.parseInt(param.get("id").toString()));

        Map<String, Object> map_result = new HashMap<>();
        if(map_board != null) map_result.put("result",200);

        map_board.put("title",param.get("title"));
        map_board.put("content",param.get("content"));
        map_board.put("author",param.get("author"));
        map_result.put("update_board",map_board);

        return map_result;
    }

    @Override
    public Map<String, Object> delete(int id) {
        Map<String, Object> map_board = getBoard(id);

        Map<String, Object> map_result = new HashMap<>();
        if(map_board != null) map_result.put("result",200);
        list.remove(id-1);

        return map_result;
    }

    public Map<String, Object> getBoard(int id) {
        for (Map<String, Object> each : list)
            if((Integer) each.get("id") == id)  return each;
        return null;
    }
}
