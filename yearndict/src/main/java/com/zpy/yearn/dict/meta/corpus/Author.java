package com.zpy.yearn.dict.meta.corpus;

import lombok.Data;

/**
 * Created by zpy on 2018/9/12.
 */
@Data
public class Author {
    private String name ;

    public Author(String name) {
        this.name = name;
    }
}
