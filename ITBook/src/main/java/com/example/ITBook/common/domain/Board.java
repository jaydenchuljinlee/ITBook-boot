package com.example.ITBook.common.domain;

import com.example.ITBook.common.enums.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * 게시판 테이블
 * */

@Entity
@Getter
@NoArgsConstructor
public class Board  implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;
    private String title;
    private String subTitle;
    private String content;
    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @ManyToOne(fetch =  FetchType.LAZY)
    private User user;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @Builder
    public Board(Long index, String title, String subTitle, String content, BoardType boardType, User user, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.index = index;
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.boardType = boardType;
        this.user = user;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
