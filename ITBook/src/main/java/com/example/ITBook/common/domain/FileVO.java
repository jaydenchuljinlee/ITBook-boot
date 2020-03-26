package com.example.ITBook.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/*
* 파일 테이블
* @author : choeljin
* */
@Builder
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "file")
public class FileVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_no")
    private long fileNo;
    @Column(name = "name",columnDefinition = "VARCHAR",length = 250)
    private String fileName;
    @Column(name = "original",columnDefinition = "VARCHAR",length = 250)
    private String original;
    @Column(name = "url",columnDefinition = "VARCHAR",length = 250)
    private String url;
    @Column(name = "created_date",columnDefinition = "DATETIME")
    private LocalDateTime createdDate;

    public void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
    }
}
