package com.example.practice.service;

import com.example.practice.config.auth.PrincipalDetail;
import com.example.practice.model.Board;
import com.example.practice.model.User;
import com.example.practice.repository.BoardRepository;
import com.example.practice.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Transactional
    public void 글쓰기(Board board, User user){
        board.setUser(user);
        board.setCount(0);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> 글목록(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    @Transactional
    public Board 글상세보기(int id){
        Board board = boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("해당 id의 글이 존재하지 않습니다. id : "+ id);
        });
        return board;
    }

    @Transactional
    public void 글수정하기(int id, Board board){
        Board board1 = boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글을 찾을 수 없습니다. id : "+id);
        });
        board1.setTitle(board.getTitle());
        board1.setContent(board.getContent());
    }

}
