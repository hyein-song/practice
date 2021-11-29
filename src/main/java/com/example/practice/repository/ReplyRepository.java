package com.example.practice.repository;

import com.example.practice.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply,Integer> {
}
