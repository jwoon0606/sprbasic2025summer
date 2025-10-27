package com.thc.sprbasic2025summer.controller;

import com.thc.sprbasic2025summer.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    final BoardService boardService;
    /*BoardRestController(BoardService boardService) { => Replace to @RequiredArgsConstructor of Lombok
        this.boardService = boardService;
    }*/

    @RequestMapping("/create")
    public Map<String, Object> create (@RequestParam Map<String,Object> param) {    //왜인진 모르겠지만 Map 으로 받을 때는 RequestParam 이 필요함
        return boardService.create(param);
    }

    @RequestMapping("/list")
    public Map<String, Object> list () {
        return boardService.list();
    }

    @RequestMapping("/detail/{id}")
    public Map<String, Object> detail (@PathVariable long id) {
        return boardService.detail(id);
    }

    @RequestMapping("/update")
    public Map<String, Object> update (@RequestParam Map<String, Object> param) {
        return boardService.update(param);
    }

    @RequestMapping("/delete")
    public Map<String, Object> delete (@RequestParam long id) {
        return boardService.delete(id);
    }
}
