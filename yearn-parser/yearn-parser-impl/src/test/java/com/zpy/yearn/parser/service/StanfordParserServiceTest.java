package com.zpy.yearn.parser.service;

import com.alibaba.fastjson.JSON;
import com.zpy.yearn.parser.common.TestBase;
import edu.stanford.nlp.trees.Constituent;
import edu.stanford.nlp.trees.LabeledScoredTreeNode;
import edu.stanford.nlp.trees.Tree;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.*;
import java.util.Set;

/**
 * Created by zpy on 2018/10/31.
 */
public class StanfordParserServiceTest extends TestBase {
    @Resource
    private StanfordParserService stanfordParserService;
    @Test
    public void testTree(){
        //Tree tree = chatbot.heard("你愚蠢地用一种极端的、黑\n" +
        //          "白分明的标准来评价你自己。");
        Tree tree =stanfordParserService.str2Tree("你用一种极端的标准来评价你自己。");
        tree.pennPrint();

        Tree testParentSib = tree.children()[0].children()[0];
        Tree parent = testParentSib.parent(tree);
        print("parent:");
        parent.pennPrint();
        parent.pennString();
        print("siblings:");
        testParentSib.siblings(tree).get(0).pennPrint();

        print("constituents: ");//树里面的边
        Set<Constituent> constituents = tree.constituents();
        for (Constituent constituent : constituents) {
            print("constituent");//Constituent的value(),label(),labels()，score()都没有结果或报错
            print(constituent);
            print("toSentenceString");
            print(constituent.toSentenceString(tree.yield()));
            print("size");
            print(constituent.size());
        }
        print("\nyield:");//展平的一句话
        print(tree.yield());
            try{
                    print("\ndependencies:");
                    print(tree.dependencies());//报错
            }catch (Exception e){
                print(e.getMessage());
            }
        print("\nflatten:");
        print(tree.flatten());
        print("\nget leaves:");
        print(tree.getLeaves());
        print("");
    }

    @Test
    public void testJsonTree(){
        Tree tree = stanfordParserService.str2Tree("你用一种极端的标准来评价你自己");

        String s = JSON.toJSONString(tree.toString(), true);
       // Object parse = JSON.parseObject(s);
        print( " tree:\n"+s);
    }
    @Test
    public void testByteSerial() throws IOException, ClassNotFoundException {
        Tree tree = stanfordParserService.str2Tree("你用一种极端的标准来评价你自己");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos);
        objectOutputStream.writeObject(tree);

        String s = bos.toString();

        print("s:"+s);

        ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bin);
        LabeledScoredTreeNode trees = (LabeledScoredTreeNode) in.readObject();

        in.close();
        objectOutputStream.close();
    }
}
