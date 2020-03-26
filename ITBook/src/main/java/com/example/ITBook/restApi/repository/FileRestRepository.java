package com.example.ITBook.restApi.repository;

import com.example.ITBook.common.domain.FileVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface FileRestRepository extends JpaRepository<FileVO,Long> {



}
