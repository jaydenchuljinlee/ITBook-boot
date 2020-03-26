package com.example.ITBook.restApi.web;

import com.example.ITBook.common.domain.FileVO;
import com.example.ITBook.restApi.repository.FileRestRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RequestMapping("/api/files")
@AllArgsConstructor
@RepositoryRestController
public class FileApiController {

    private FileRestRepository fileRestRepository;

    @GetMapping()
    @ResponseBody
    public CollectionModel<FileVO> fileApi(@PageableDefault Pageable pageable) throws Exception {

        Page<FileVO> files = fileRestRepository.findAll(pageable);

        PagedModel.PageMetadata pageMetadata =
                new PagedModel.PageMetadata(pageable.getPageSize(),files.getNumber(),files.getNumberOfElements());

        PagedModel<FileVO> resorces = new PagedModel<>(files.getContent(),pageMetadata);

        resorces.add(linkTo(methodOn(FileApiController.class).fileApi(pageable)).withSelfRel());

        return resorces;
    }
}