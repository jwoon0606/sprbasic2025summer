package com.thc.sprbasic2025summer.service;

import com.thc.sprbasic2025summer.dto.BoardDto;

import java.util.Map;

public interface BoardService {
    BoardDto.CreateResDto create(BoardDto.CreateReqDto param);
    Map<String,Object> list();
    Map<String,Object> detail(long id);
    Map<String, Object> update (BoardDto.UpdateReqDto param);
    Map<String, Object> delete (Map<String, Object> param);
}
