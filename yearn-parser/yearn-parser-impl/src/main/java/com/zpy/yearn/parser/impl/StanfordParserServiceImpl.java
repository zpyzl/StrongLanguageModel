package com.zpy.yearn.parser.impl;

import com.zpy.yearn.parser.service.StanfordParserService;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.SentenceUtils;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.trees.Tree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Created by zpy on 2018/8/30.
 */
@Service("StanfordParserService")
public class StanfordParserServiceImpl implements StanfordParserService{
    private static final Logger logger = LoggerFactory.getLogger(StanfordParserService.class);

    @Resource
    private ChSegService chSegService;

    private LexicalizedParser chLexicalParser;
    /*@Override
    public String prettyPrint(String sentenceStr){
        List<String> seggedSentence = chSegService.seg(sentenceStr);

        Tree tree = parseTree(seggedSentence.toArray(new String[seggedSentence.size()]));
        return TreeTraverser.prettyPrintTree(tree);
    }*/
    @Override
    public Tree str2Tree(String sentenceStr){
        List<String> seggedSentence = chSegService.seg(sentenceStr);

        return parseTree(seggedSentence.toArray(new String[seggedSentence.size()]));
    }

    @Override
    public byte[] stc2TreeBytes(String sentenceStr) {
        Tree tree = str2Tree(sentenceStr);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(bos);
            objectOutputStream.writeObject(tree);
            objectOutputStream.close();
        } catch (IOException e) {
            logger.error("failed to serialize tree, msg: {}",e.getMessage());
        }

        return bos.toByteArray();
    }

    @PostConstruct
    public void initParser(){
        String parserModel = "edu/stanford/nlp/models/lexparser/chineseFactored.ser.gz";
        chLexicalParser = LexicalizedParser.loadModel(parserModel);
    }
    @Override
    public Tree parseTree(String[] sent) {
        List<CoreLabel> rawWords = SentenceUtils.toCoreLabelList(sent);
        Tree tree = this.chLexicalParser.apply(rawWords);
        tree.pennPrint();
        //logger.info(prettyPrintTree(tree));
        return tree;
    }

/*

    @Override
    public String prettyPrintTree(Tree tree) {
        return TreeTraverser.prettyPrintTree(tree);
    }
*/

}
