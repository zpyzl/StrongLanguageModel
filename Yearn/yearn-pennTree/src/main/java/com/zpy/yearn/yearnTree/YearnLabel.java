/*
 * Copyright(c)2018-2020, 赵鹏阳
 * 项目名称:Yearn 文件名称:YearnLabel.java
 * Date:2020/1/1 下午9:21
 * Author: 赵鹏阳
 */

package com.zpy.yearn.yearnTree;

import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.ling.LabelFactory;
import lombok.Data;

/**
 * Created by zpy on 2018/10/31.
 */
@Data
public class YearnLabel implements Label {
    private String labelStr;

    @Override
    public String value() {
        return labelStr;
    }

    @Override
    public void setValue(String s) {
        this.labelStr = s;
    }

    @Override
    public void setFromString(String s) {
        setValue(s);
    }

    @Override
    public LabelFactory labelFactory() {
        return null;
    }
}
