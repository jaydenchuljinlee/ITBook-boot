package com.example.ITBook.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ITBook.repository.BoardRepository;
import com.example.ITBook.domain.Board;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
	
	@Override
	public Optional<Board> findBoardByIndex(Long index) {
		
		return boardRepository.findById(index);
	}

	@Override
	public Page<Board> findBoardList(Pageable pageable) {
		int pageNumber = pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1;
        pageable = PageRequest.of(pageNumber, pageable.getPageSize(), new Sort(Sort.Direction.DESC, "index"));

        return boardRepository.findAll(pageable);
	}

	
}
