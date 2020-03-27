package com.example.ITBook.restApi.web;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.restApi.repository.UserRestRepository;
import com.example.ITBook.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


/*
* ȸ������ Rest Controller
* */
@Slf4j
@RequestMapping("/api/user")
@AllArgsConstructor
@RepositoryRestController
public class UserRestApiController {

    private UserRestRepository userRestRepository;

    /*
    * ���� HATOES ���� 1.0 �̻�
    * HATOES 1.0 ���� �������� ���Ǵ� Resources<T>�� CollectionModel<T>�� ����, PagedResources<T>�� PagedModel<T>�� ����
    * */
    @GetMapping()
    @ResponseBody
    public CollectionModel<User> userApiController(@PageableDefault Pageable pageable) throws Exception {

        log.info("UserRestApiController.userApiController :::");

        Page<User> userList = userRestRepository.findAll(pageable);

        // ������ ������ ��� PageMetadata ��ü�� ����
        PagedModel.PageMetadata pageMetadata =
                new PagedModel.PageMetadata(pageable.getPageSize(),userList.getNumber(),userList.getTotalElements());

        // �÷����� ������ ���ҽ� ������ �߰������� �����ϴ� PagedResources ��ü ���� �� ��ȯ
        PagedModel<User> resources = new PagedModel<>(userList.getContent(),pageMetadata);
        // �ʿ��� ��ũ�� �߰� : ��û�� ������ Board�� ��Ÿ���� 'self' �ϳ��� �ӽ÷� �߰���
        resources.add(linkTo(methodOn(UserRestApiController.class).userApiController(pageable)).withSelfRel());

        return resources;
    }
}
