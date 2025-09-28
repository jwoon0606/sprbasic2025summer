package com.thc.sprbasic2025summer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    List<Map<String,Object>> list = new ArrayList<>();
    int tempId = 0;

    @RequestMapping("/create")
    public Map<String, Object> create (@RequestParam Map<String,Object> param) {    //왜인진 모르겠지만 Map 으로 받을 때는 RequestParam 이 필요함
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

    @RequestMapping("/list")
    public Map<String, Object> list () {
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("result",200);
        map_result.put("totalsize",list.size());
        map_result.put("list",list);

        return map_result;
    }

    @RequestMapping("/detail/{id}")
    public Map<String, Object> detail (@PathVariable int id) {
        Map<String, Object> map_board = getBoard(id);

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("result",200);
        map_result.put("board",map_board);

        return map_result;
    }

    @RequestMapping("/update")
    public Map<String, Object> update (@RequestParam Map<String, Object> param) {
        Map<String, Object> map_board = getBoard(Integer.parseInt(param.get("id").toString()));

        Map<String, Object> map_result = new HashMap<>();
        if(map_board != null) map_result.put("result",200);

        map_board.put("title",param.get("title"));
        map_board.put("content",param.get("content"));
        map_board.put("author",param.get("author"));
        map_result.put("update_board",map_board);

        return map_result;
    }

    @RequestMapping("/delete")
    public Map<String, Object> delete (@RequestParam int id) {
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
