package com.crud.backend.controller;

import com.crud.backend.domain.Board;
import com.crud.backend.domain.PageResultBoard;
import com.crud.backend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    
    // 전체 데이터 반환
    @GetMapping(value = "")
    public ResponseEntity<PageResultBoard> getBoards(@RequestParam(value = "page", defaultValue = "0") int pageNum) {

        PageResultBoard pageResultBoard = boardService.findBoards(pageNum);


        return new ResponseEntity<>(pageResultBoard, HttpStatus.OK);
    }
    
    // id 글 반환
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Board>> getBoard(@PathVariable("id") Long id) {

        Optional<Board> result = boardService.findBoardById(id);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    // board 생성
    @PostMapping(value = "")
    public ResponseEntity<Long> createBoard(@RequestBody Board board) {

        Long result = boardService.writeBoard(board);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // id 글 수정
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> updateBoard(@PathVariable("id") Long id, @RequestBody Board board) {

        board.setId(id);
        Long result = boardService.writeBoard(board);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // id 글 삭제
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeBoard(@PathVariable("id") Long id) {

        String msg = boardService.removeBoard(id);

        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
