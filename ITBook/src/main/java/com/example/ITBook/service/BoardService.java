package com.example.ITBook.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.ITBook.common.domain.Board;

public interface BoardService {

	Optional<Board> findBoardByIndex(Long index);

	Page<Board> findBoardList(Pageable pageable);

}
