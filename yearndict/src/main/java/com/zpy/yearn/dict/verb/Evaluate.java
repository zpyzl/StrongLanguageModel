package com.zpy.yearn.dict.verb;

import com.zpy.yearn.dict.creature.IntelligentBody;
import com.zpy.yearn.dict.noun.Value;
import com.zpy.yearn.dict.meta.pos.Noun;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * POST dict/_doc/evaluate
 * {
 *   "word":["评价"],
 *   "trans_su":"evaluate",
 *   "pos":"v",
 *   "content":"ib,obj-> ::value",
 *   "comment":"得出表示价值的话语"
 * }
 * Created by zpy on 2018/10/8.
 */
public class Evaluate<IntelligentBody,Noun,Value> extends VerbT {

    private List<String> word = Collections.singletonList("评价");
    //动词的第一个参数是主语，第二个是宾语



    Value apply(IntelligentBody ib, Noun obj);

    @Override
    public Object apply(Object o, Object o2) {
        return null;
    }
}
