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
    * 초기 화면
    * */
    @GetMapping()
    public String fileFront() throws Exception{

        return "fileUpload/file.tiles2";
    }

    /*
    * 파일 업로드
    * @author : cheoljin
    * */
    @PostMapping("/upload")
    public String fileApiUpload(@RequestPart MultipartFile files) throws Exception {

        log.info("fileFrontController.fileApiUpload :::");

        //files에서 이름과 확장자르 가져옴
        String original     = files.getOriginalFilename();
        String extension    = FilenameUtils.getExtension(original).toLowerCase();

        // 서버에 저장할 파일 객체 생성
        File file;
        String fileName;
        String fileUrl  = "C:\\boot\\ITBook\\ITBook\\src\\main\\webapp\\WEB-INF\\uploadFiles\\";

        do {
            fileName = RandomStringUtils.randomAlphanumeric(32) + "." + extension;
            file = new File(fileUrl + fileName);

        } while(file.exists());

        //파일 상위에 디렉토리 생성 후 files를 파일로 변경
        file.getParentFile().mkdirs();
        files.transferTo(file);


        //파일 VO 객체 생성
        FileVO vo = FileVO.builder()
                        .fileName(fileName)
                        .original(original)
                        .url(fileUrl)
                        .createdDate(LocalDateTime.now())
                        .build();

        //파일 객체 저장
        fileRepository.save(vo);

        return "redirect:/api/files";
    }
}
