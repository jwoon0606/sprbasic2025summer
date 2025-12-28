package com.thc.sprbasic2025summer.service;

import com.thc.sprbasic2025summer.dto.BoardDto;
import com.thc.sprbasic2025summer.dto.DefaultDto;

import java.util.Map;

public interface BoardService {
    DefaultDto.CreateResDto create(BoardDto.CreateReqDto param);
    Map<String,Object> list();
    BoardDto.DetailResDto detail(long id);
    Map<String, Object> update (BoardDto.UpdateReqDto param);
    Map<String, Object> delete (Map<String, Object> param);
}
