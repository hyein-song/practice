package com.example.practice.controller.api;

import com.example.practice.config.auth.PrincipalDetail;
import com.example.practice.dto.ResponseDto;
import com.example.practice.model.Board;
import com.example.practice.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){
        System.out.println("board 내용 : "+board.getTitle()+" "+board.getContent());
        boardService.글쓰기(board, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
        boardService.글수정하기(id,board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("api/board/{id}")
    public ResponseDto<Integer> delete(@PathVariable int id){
        boardService.글삭제하기(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
