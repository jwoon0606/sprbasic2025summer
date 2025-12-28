package com.thc.sprbasic2025summer.entity;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Setter
@Getter
@Entity
public class Board extends AuditingField{
    String title;
    String content;
    String author;

    protected Board() {}    // 못쓰게 할 예정
    private Board (String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }   // 이 생성자도 못쓰게 함

    // 이 메서드를 통해서만 데이터 생성 가능
    public static Board of (String title, String content, String author) {
        return new Board(title,content,author);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
