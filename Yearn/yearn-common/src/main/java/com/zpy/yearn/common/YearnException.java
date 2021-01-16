/*
 * Copyright(c)2018-2020, 赵鹏阳
 * 项目名称:Yearn 文件名称:YearnException.java
 * Date:2020/1/1 下午9:21
 * Author: 赵鹏阳
 */

package com.zpy.yearn.common;

/**
 * Created by zpy on 2017/4/13.
 */
public class YearnException extends Exception{
    private String msg;
    private Exception e;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //Logger logger = LoggerFactory.getLogger(YearnException.class);
    public YearnException(String msg,Exception e){
        this.msg = msg;
        this.e = e;
    }
    public YearnException(String msg){
        this.msg = msg;
    }
}
