package com.thc.sprbasic2025summer.dto;

import com.thc.sprbasic2025summer.entity.Board;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

public class BoardDto {
    @Setter @Getter @Builder
    public static class CreateReqDto {
        String title;
        String content;
        String author;

        public Board toEntity() {
            return Board.of(getTitle(), getContent(), getAuthor());
        }
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto{
//        Long id;
        String title;
        String content;
        String author;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto extends DefaultDto.DetailResDto{
        /*Long id;
        Boolean deleted;
        LocalDateTime createdAt;
        LocalDateTime modifiedAt;*/
        String title;
        String content;
        String author;
    }
}
