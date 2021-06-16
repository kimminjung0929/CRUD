package com.crud.backend.repository;

import com.crud.backend.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    // 페이징 작업
    Page<Board> findAll(Pageable pageable);
}
