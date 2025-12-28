package com.thc.sprbasic2025summer.service.impl;

import com.thc.sprbasic2025summer.dto.BoardDto;
import com.thc.sprbasic2025summer.dto.DefaultDto;
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
    public DefaultDto.CreateResDto create(BoardDto.CreateReqDto param) {
        return boardRepository.save(param.toEntity()).toCreateResDto();
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
    public BoardDto.DetailResDto detail(long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no data"));

        return BoardDto.DetailResDto.builder().id(board.getId())
                .deleted(board.getDeleted()).createdAt(board.getCreatedAt())
                .modifiedAt(board.getModifiedAt()).title(board.getTitle())
                .content(board.getContent()).author(board.getAuthor()).build();
    }

    @Override
    public Map<String, Object> update(BoardDto.UpdateReqDto param) {
        int code = 200;
        long id = param.getId();

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no data"));
        /*Board board = boardRepository.findById(id)
                .orElse(null);*/
        if(param.getTitle() != null) { board.setTitle(param.getTitle()); }
        if(param.getContent() != null) { board.setContent(param.getContent()); }
        if(param.getAuthor() != null) { board.setAuthor(param.getAuthor()); }
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
//
//        boardRepository.delete(board);
        board.setDeleted(true);
        boardRepository.save(board);

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", 200);

        return map_result;
    }
}
