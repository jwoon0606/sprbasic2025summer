package com.thc.sprbasic2025summer.controller;

import com.thc.sprbasic2025summer.dto.BoardDto;
import com.thc.sprbasic2025summer.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    final BoardService boardService;
    /*BoardRestController(BoardService boardService) { => Replace to @RequiredArgsConstructor of Lombok
        this.boardService = boardService;
    }*/

    @PostMapping("") // post 방식으로 받을 때는 @RequestParm이 아닌 @RequestBody를 사용해야 함
    public BoardDto.CreateResDto create (@RequestBody BoardDto.CreateReqDto param) {    //왜인진 모르겠지만 Map 으로 받을 때는 RequestParam 이 필요함
        return boardService.create(param);
    }

    @GetMapping("/list")
    public Map<String, Object> list () {
        return boardService.list();
    }

    @GetMapping("/detail/{id}")
    public Map<String, Object> detail (@PathVariable long id) {
        return boardService.detail(id);
    }

    @PutMapping("")
    public Map<String, Object> update (@RequestBody BoardDto.UpdateReqDto param) {
        return boardService.update(param);
    }

    @DeleteMapping("")
    public Map<String, Object> delete (@RequestBody Map<String,Object> param) {
        return boardService.delete(param);
    }
}
