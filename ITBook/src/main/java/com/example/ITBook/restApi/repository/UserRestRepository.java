package com.example.ITBook.restApi.repository;

import com.example.ITBook.common.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource()// ��Ʈ�ѷ��� ���� ���� ���� �̸� ���������� ���ǵǾ� �ִ� ������ ���� ó���ȴ�.
public interface UserRestRepository extends JpaRepository<User,Long> {


    @RestResource(exported = false)
    List<User> findByName(@Param("name") String name);
}
