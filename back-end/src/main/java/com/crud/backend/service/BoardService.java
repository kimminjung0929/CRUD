package com.crud.backend.service;

import com.crud.backend.domain.Board;
import com.crud.backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Board> findBoards() {
        return boardRepository.findAll();
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
