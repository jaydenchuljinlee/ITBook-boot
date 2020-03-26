package com.example.ITBook.restApi.repository;

import com.example.ITBook.common.domain.FileVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileVO,Long> {
}
