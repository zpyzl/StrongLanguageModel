/*
 * Copyright(c)2018-2020, 赵鹏阳
 * 项目名称:Yearn 文件名称:YearnLabelFactory.java
 * Date:2020/1/1 下午9:21
 * Author: 赵鹏阳
 */

package com.zpy.yearn.yearnTree;

import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.ling.LabelFactory;

/**
 * Created by zpy on 2018/10/31.
 */
public class YearnLabelFactory implements LabelFactory {
    public static Label createLabel(String s){
        Label label = new YearnLabel();
        label.setFromString(s);
        return label;
    }
    @Override
    public Label newLabel(String s) {
        return createLabel(s);
    }

    @Override
    public Label newLabel(String s, int i) {
        return null;
    }

    @Override
    public Label newLabelFromString(String s) {
        return newLabel(s);
    }

    @Override
    public Label newLabel(Label label) {
        return label;
    }
}
