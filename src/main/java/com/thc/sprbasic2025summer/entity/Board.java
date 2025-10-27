package com.thc.sprbasic2025summer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Board {
    @Id Long id;    // @Id는 테이블에서 PK로 사용되는 것! 무조건 unique 해야 함..
    String title;
    String content;
    String author;
}
