package com.crud.backend.service;

import com.crud.backend.domain.Board;
import com.crud.backend.domain.PageResultBoard;
import com.crud.backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public PageResultBoard findBoards(int pageNum) {
        // of.( 페이지번호, 페이지 당 데이터 개수, 정렬 )
        Pageable pageable = PageRequest.of( pageNum, 3, Sort.by("id").descending());

        Page<Board> results = boardRepository.findAll(pageable);

        PageResultBoard pageResultBoard = new PageResultBoard();

        // 리스트
        pageResultBoard.setBoardLists(results.getContent());
        // 마지막 페이지 번호
        int totalPage;
        if (results.getTotalPages() - 1 < 0 ) {
            totalPage = 0;
        } else {
            totalPage = results.getTotalPages() - 1;
        }

        pageResultBoard.setTotalPage(totalPage);
        // 현재 페이지
        pageResultBoard.setCurrentPage(results.getNumber());
        // 끝 파이지
        int endPage = Math.min(totalPage, results.getNumber() + 2);
        pageResultBoard.setEndPage(endPage);

        return pageResultBoard;
    }

    public Optional<Board> findBoardById(Long id) {
        return boardRepository.findById(id);
    }

    public Long writeBoard(Board board) {
        Board result = boardRepository.save(board);

        return result.getId();
    }

    public String removeBoard(Long id) {
        boardRepository.deleteById(id);

        return "Success";
    }


}
