package com.example.ITBook.repository;

import com.example.ITBook.domain.Board;
import com.example.ITBook.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    public Optional<Board> findByUser(User user);
}
