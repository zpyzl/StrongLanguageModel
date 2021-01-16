package com.zpy.yearn.dict.meta.sense;

import com.zpy.yearn.dict.meta.bot.BotMode;
import com.zpy.yearn.dict.meta.pos.POS;
import com.zpy.yearn.dict.meta.pos.Tag;
import lombok.Data;

import java.util.List;

/**
 * Created by zpy on 2018/7/23.
 */
@Data
public class Sense {
//public abstract class Sense {
    //private CollinsPOS collinsPOS;
    private List<String> word;
    private String trans;
    private String transSu;//英语中同样用法的单词
    private POS pos;
    private VarType varType;
    private Tag tag;
    private String after;
    private String before;
    private String with;
    private BotMode mode;
    private String content;


}
