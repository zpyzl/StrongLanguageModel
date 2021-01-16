package com.zpy.yearn.dict.meta.corpus;

import lombok.Data;

import java.util.List;

/**
 * Created by zpy on 2018/9/12.
 */
@Data
public class BookPart {
    private String title;
    private String content;
    private List<BookPart> parts;

    public BookPart(String title) {
        this.title = title;
    }

    public BookPart(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
