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
* 회원정보 Rest Controller
* */
@Slf4j
@RequestMapping("/api/user")
@AllArgsConstructor
@RepositoryRestController
public class UserRestApiController {

    private UserRestRepository userRestRepository;

    /*
    * 현재 HATOES 버전 1.0 이상
    * HATOES 1.0 이전 버전에서 사용되던 Resources<T>는 CollectionModel<T>로 변경, PagedResources<T>는 PagedModel<T>로 변경
    * */
    @GetMapping()
    @ResponseBody
    public CollectionModel<User> userApiController(@PageableDefault Pageable pageable) throws Exception {

        log.info("UserRestApiController.userApiController :::");

        Page<User> userList = userRestRepository.findAll(pageable);

        // 페이지 정보를 담는 PageMetadata 객체를 생성
        PagedModel.PageMetadata pageMetadata =
                new PagedModel.PageMetadata(pageable.getPageSize(),userList.getNumber(),userList.getTotalElements());

        // 컬렉션의 페이지 리소스 정보를 추가적으로 제공하는 PagedResources 객체 생성 후 반환
        PagedModel<User> resources = new PagedModel<>(userList.getContent(),pageMetadata);
        // 필요한 링크를 추가 : 요청된 각각의 Board를 나타내는 'self' 하나만 임시로 추가함
        resources.add(linkTo(methodOn(UserRestApiController.class).userApiController(pageable)).withSelfRel());

        return resources;
    }
}
