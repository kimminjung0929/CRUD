package com.crud.backend.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PageResultBoard {

    // board 리스트
    private List<Board> boardLists;

    // 마지막 페이지 번호
    private int totalPage;

    // 현재 페이지
    private int currentPage;

    // 시작, 끝 페이지
    private int endPage;

}
