package com.zpy.yearn.parser.service;

import edu.stanford.nlp.trees.Tree;

/**
 * Created by zpy on 2018/8/30.
 */
public interface StanfordParserService {


     //String prettyPrint(String sentenceStr);

     Tree str2Tree(String sentenceStr);
     byte[] stc2TreeBytes(String sentenceStr);


     Tree parseTree(String[] sent);


     //String prettyPrintTree(Tree tree);

}
