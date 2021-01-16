package com.zpy.yearn.parser.controller;


import com.alibaba.fastjson.JSON;
import com.zpy.yearn.parser.service.StanfordParserService;
import edu.stanford.nlp.trees.Tree;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zpy on 2018/8/31.
 */


@RestController
public class StanfordParserController {
    @Resource
    private StanfordParserService stanfordParserService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }
    /*@PostMapping("/tellChatbot")
    public String tellChatbot(@RequestParam String sentences) {
        return stanfordParserService.prettyPrint(sentences);
    }*/
    @GetMapping("/sentenceTree")
    public String sentenceTree(@RequestParam String sentence) {
        Tree tree = stanfordParserService.str2Tree(sentence);
        tree.yield();

        return JSON.toJSONString(tree);
    }
    /*@GetMapping("/sentence2YTree")
    public String sentence2YTree(@RequestParam String sentence) {
        YearnTree yearnTree = stanfordParserService.sentence2YTree(sentence);
        return JSON.toJSONString(yearnTree);
    }*/

}
