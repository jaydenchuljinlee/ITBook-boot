package com.example.ITBook.common.enums;

import lombok.Getter;

@Getter
public enum BoardType {
    notice("ê³µì??‚¬?•­"), free("??œ ê²Œì‹œ?Œ");

    private String value;

    BoardType(String value) {
        this.value = value;
    }
}
