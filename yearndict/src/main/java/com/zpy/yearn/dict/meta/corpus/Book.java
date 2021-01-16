package com.zpy.yearn.dict.meta.corpus;

import lombok.Data;

import java.util.List;

/**
 * Created by zpy on 2018/9/12.
 */
@Data
public class Book {
    private String title;
    private Author author;
    private List<BookPart> parts;

    public Book(String title) {
        this.title = title;
    }
}
