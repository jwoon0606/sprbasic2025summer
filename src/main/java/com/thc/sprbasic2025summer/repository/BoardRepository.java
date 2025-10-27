package com.thc.sprbasic2025summer.repository;

import com.thc.sprbasic2025summer.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {  // 제너릭에는 항상 클래스 타입만 가능

}