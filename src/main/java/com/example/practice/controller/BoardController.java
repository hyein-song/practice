package com.example.practice.controller;

import com.example.practice.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping({"","/"})
    public String index(Model model, @PageableDefault(size = 3,sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        System.out.println("index controller 호출");
        model.addAttribute("boards", boardService.글목록(pageable));
        System.out.println("index controller 호출 완료");
        return "index";
    }
}
