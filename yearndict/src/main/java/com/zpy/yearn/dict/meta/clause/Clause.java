package com.zpy.yearn.dict.meta.clause;

import com.zpy.yearn.dict.YearnTree;
import com.zpy.yearn.dict.meta.pos.Noun;
import com.zpy.yearn.dict.verb.VerbT;
import edu.stanford.nlp.trees.Tree;
import lombok.Data;

/**
 * Created by zpy on 2018/9/20.
 */
@Data
public class Clause extends SentenceElement implements ToSetSubject,ToSetPredicate {
    private YearnTree ytree;
    private Noun subject;
    private Predicate predicate;

    /*public Clause(Tree tree){
        super(tree);
    }*/
    @Override
    public void setSubject(Noun n) {
        setSubject(n);
    }


    @Override
    public YearnTree getYTree() {
        return ytree;
    }

    @Override
    public void setPredicate(VerbT v) {
        setPredicate(v);
    }
}
