package com.thc.sprbasic2025summer.service.impl;

import com.thc.sprbasic2025summer.dto.BoardDto;
import com.thc.sprbasic2025summer.entity.Board;
import com.thc.sprbasic2025summer.repository.BoardRepository;
import com.thc.sprbasic2025summer.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    final BoardRepository boardRepository;
    /*BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }*/

    /*List<Map<String,Object>> list = new ArrayList<>();
    int tempId = 0;*/

    @Override
    public BoardDto.CreateResDto create(BoardDto.CreateReqDto param) {
        String title = String.valueOf(param.getTitle());
        String content = String.valueOf(param.getContent());
        String author = String.valueOf(param.getAuthor());

        Board board = Board.of(title, content, author);
        boardRepository.save(board);


        /*BoardDto.CreateResDto resDto = new BoardDto.CreateResDto();
        resDto.setId(board.getId());*/
        return BoardDto.CreateResDto.builder().id(board.getId()).build();
    }

    @Override
    public Map<String, Object> list() {
        List<Board> list = boardRepository.findAll();

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        map_result.put("list", list);

        return map_result;
    }

    @Override
    public Map<String, Object> detail(long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no data"));

        int resultCode = 200;
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", resultCode);
        map_result.put("board", board);

        return map_result;
    }

    @Override
    public Map<String, Object> update(BoardDto.UpdateReqDto param) {
        int code = 200;
        long id = param.getId();

        String title = param.getTitle();
        String content = param.getContent();
        String author = param.getAuthor();

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no data"));
        /*Board board = boardRepository.findById(id)
                .orElse(null);*/
        if(param.getTitle() != null) { board.setTitle(title); }
        if(param.getContent() != null) { board.setContent(content); }
        if(param.getAuthor() != null) { board.setAuthor(author); }
        boardRepository.save(board);

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", code);
        map_result.put("board", board);

        return map_result;
    }

    @Override
    public Map<String, Object> delete(Map<String, Object> param) {
        long id = Long.parseLong(param.get("id").toString());
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no data"));

        boardRepository.delete(board);

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", 200);

        return map_result;
    }
}
