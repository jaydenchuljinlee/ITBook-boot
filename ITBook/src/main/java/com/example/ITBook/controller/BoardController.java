package com.example.ITBook.controller;

import com.example.ITBook.common.domain.Board;
import com.example.ITBook.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping({"", "/"})
    public String board(@RequestParam(value = "index", defaultValue = "0") Long index,
                        Model model) {
        Board board = boardService.findBoardByIndex(index).orElse(null);
        model.addAttribute("board", board);

        return "board/board.default";
    }

    @GetMapping("/list")
    public String list(@PageableDefault Pageable pageable, Model model) {
        Page<Board> boardList = boardService.findBoardList(pageable);

        model.addAttribute("boardList", boardList);

        log.debug("Ï¥? element ?àò : {}, ?†ÑÏ≤? page ?àò : {}, ?éò?ù¥Ïß??óê ?ëú?ãú?ï† element ?àò : {}, ?òÑ?û¨ ?éò?ù¥Ïß? index : {}, ?òÑ?û¨ ?éò?ù¥Ïß??ùò element ?àò : {}",
                boardList.getTotalElements(), boardList.getTotalPages(), boardList.getSize(),
                boardList.getNumber(), boardList.getNumberOfElements());

        return "board/list";
    }
}
