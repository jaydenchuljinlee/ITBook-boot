package com.example.ITBook.restApi.web;

import com.example.ITBook.common.domain.FileVO;
import com.example.ITBook.restApi.repository.FileRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;

@Slf4j
@RequestMapping("/file")
@Controller @AllArgsConstructor
public class fileFrontController {

    private FileRepository fileRepository;

    /*
    * �ʱ� ȭ��
    * */
    @GetMapping()
    public String fileFront() throws Exception{

        return "fileUpload/file.tiles2";
    }

    /*
    * ���� ���ε�
    * @author : cheoljin
    * */
    @PostMapping("/upload")
    public String fileApiUpload(@RequestPart MultipartFile files) throws Exception {

        log.info("fileFrontController.fileApiUpload :::");

        //files���� �̸��� Ȯ���ڸ� ������
        String original     = files.getOriginalFilename();
        String extension    = FilenameUtils.getExtension(original).toLowerCase();

        // ������ ������ ���� ��ü ����
        File file;
        String fileName;
        String fileUrl  = "C:\\boot\\ITBook\\ITBook\\src\\main\\webapp\\WEB-INF\\uploadFiles\\";

        do {
            fileName = RandomStringUtils.randomAlphanumeric(32) + "." + extension;
            file = new File(fileUrl + fileName);

        } while(file.exists());

        //���� ������ ���丮 ���� �� files�� ���Ϸ� ����
        file.getParentFile().mkdirs();
        files.transferTo(file);


        //���� VO ��ü ����
        FileVO vo = FileVO.builder()
                        .fileName(fileName)
                        .original(original)
                        .url(fileUrl)
                        .createdDate(LocalDateTime.now())
                        .build();

        //���� ��ü ����
        fileRepository.save(vo);

        return "redirect:/api/files";
    }
}
