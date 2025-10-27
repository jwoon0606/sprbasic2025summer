package com.thc.sprbasic2025summer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
public class Board {
    @Id     // @Id는 테이블에서 PK로 사용되는 것! 무조건 unique 해야 함..
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id값은 자동으로 올라가게 해줌.
    Long id;

    @Setter String title;
    @Setter String content;
    @Setter String author;

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
}
