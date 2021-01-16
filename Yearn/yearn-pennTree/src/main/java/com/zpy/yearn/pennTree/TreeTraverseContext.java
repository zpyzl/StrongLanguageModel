/*
 * Copyright(c)2018-2020, 赵鹏阳
 * 项目名称:Yearn 文件名称:TreeTraverseContext.java
 * Date:2020/1/1 下午9:21
 * Author: 赵鹏阳
 */

package com.zpy.yearn.pennTree;

import lombok.Data;

/**
 * Created by zpy on 2018/9/21.
 */
public class TreeTraverseContext {
    private StringBuilder prettyPrint = new StringBuilder();
    //private Tree clauseTree;
    private int depth = 0;
    //private Tree parentYTree;
    //private Stack<ToSetClause> toSets;

    public StringBuilder getPrettyPrint() {
        return prettyPrint;
    }

    public void setPrettyPrint(StringBuilder prettyPrint) {
        this.prettyPrint = prettyPrint;
    }

    public void incrementDepth(){
        this.depth++;
    }
    /*public Tree getParentTree(){
        return this.getParentYTree().getTree();
    }*/
}
