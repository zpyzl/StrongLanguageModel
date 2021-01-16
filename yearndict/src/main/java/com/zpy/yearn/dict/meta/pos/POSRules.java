package com.zpy.yearn.dict.meta.pos;

import com.zpy.yearn.rules.dict.yearn.Sense;
import edu.stanford.nlp.trees.Tree;

/**
 * Created by zpy on 2018/9/15.
 */
public class POSRules {

    public static String genTreeContent(String word, Sense sense, String tag, Tree tree){
        Tag pos = Tag.valueOf(tag);
        if( pos.equals(Tag.PN)){
            //tree.
           //  sense.getVarType()
        }

        return null;
    }

    public static boolean contains(POS pos, Tag tag) {
        //if( POS.N)
        return false;
    }
}
