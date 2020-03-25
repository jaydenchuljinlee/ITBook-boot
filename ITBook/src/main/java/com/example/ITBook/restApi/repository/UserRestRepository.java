package com.example.ITBook.restApi.repository;

import com.example.ITBook.common.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource()// 컨트롤러와 서비스 영역 없이 미리 내부적으로 정의되어 있는 로직을 따라 처리된다.
public interface UserRestRepository extends JpaRepository<User,Long> {


    @RestResource(exported = false)
    List<User> findByName(@Param("name") String name);
}
