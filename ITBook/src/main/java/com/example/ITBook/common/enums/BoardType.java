package com.example.ITBook.common.enums;

import lombok.Getter;

@Getter
public enum BoardType {
    notice("공�??��?��"), free("?��?��게시?��");

    private String value;

    BoardType(String value) {
        this.value = value;
    }
}
