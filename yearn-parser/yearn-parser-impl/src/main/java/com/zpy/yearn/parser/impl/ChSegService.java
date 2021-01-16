package com.zpy.yearn.parser.impl;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Properties;

/**
 * 分词
 * Created by zpy on 2018/8/27.
 */
@Component
public class ChSegService {

    private static final String basedir = System.getProperty("SegDemo", "data");

    private  CRFClassifier<CoreLabel> chSegmenter;

    @PostConstruct
    private CRFClassifier<CoreLabel> init() throws IOException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        Properties props = new Properties();
        props.setProperty("sighanCorporaDict", basedir);
        // props.setProperty("NormalizationTable", "data/norm.simp.utf8");
        // props.setProperty("normTableEncoding", "UTF-8");
        // below is needed because CTBSegDocumentIteratorFactory accesses it
        props.setProperty("serDictionary", basedir + "/dict-chris6.ser.gz");
        /*if (args.length > 0) {
            props.setProperty("testFile", args[0]);
        }*/
        props.setProperty("inputEncoding", "UTF-8");
        props.setProperty("sighanPostProcessing", "true");

        chSegmenter = new CRFClassifier<>(props);

        chSegmenter.loadClassifierNoExceptions(basedir + "/ctb.gz", props);
       /* for (String filename : args) {
            chSegmenter.classifyAndWriteAnswers(filename);
        }*/
        return chSegmenter;
    }

    public List<String> seg(String sentenceStr){
        return chSegmenter.segmentString(sentenceStr);
    }
}
