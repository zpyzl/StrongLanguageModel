/*
 * Copyright(c)2018-2020, 赵鹏阳
 * 项目名称:Yearn 文件名称:ParserDemo2.java
 * Date:2020/1/1 下午9:21
 * Author: 赵鹏阳
 */

package com.zpy.yearn.stanfordParser;

import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.trees.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

class ParserDemo2 {

  /** This example shows a few more ways of providing input to a parser.
   *
   *  Usage: ParserDemo2 [grammar [textFile]]
   */
  public static void main(String[] args) throws IOException {
    String grammar = args.length > 0 ? args[0] : "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";
    String[] options = { "-maxLength", "80", "-retainTmpSubcategories" };
    LexicalizedParser lp = LexicalizedParser.loadModel(grammar, options);
    TreebankLanguagePack tlp = lp.getOp().langpack();
    GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();

    Iterable<List<? extends HasWord>> sentences;
    if (args.length > 1) {
      DocumentPreprocessor dp = new DocumentPreprocessor(args[1]);
      List<List<? extends HasWord>> tmp =
              new ArrayList<>();
      for (List<HasWord> sentence : dp) {
        tmp.add(sentence);
      }
      sentences = tmp;
    } else {
      // Showing tokenization and parsing in code a couple of different ways.
      String[] sent = { "This", "is", "an", "easy", "sentence", "." };
      List<HasWord> sentence = new ArrayList<>();
      for (String word : sent) {
        sentence.add(new Word(word));
      }

      String sent2 = ("This is a slightly longer and more complex " +
                      "sentence requiring tokenization.");
      // Use the default tokenizer for this TreebankLanguagePack
      Tokenizer<? extends HasWord> toke =
        tlp.getTokenizerFactory().getTokenizer(new StringReader(sent2));
      List<? extends HasWord> sentence2 = toke.tokenize();

      String[] sent3 = { "It", "can", "can", "it", "." };
      String[] tag3 = { "PRP", "MD", "VB", "PRP", "." }; // Parser gets second "can" wrong without help
      List<TaggedWord> sentence3 = new ArrayList<>();
      for (int i = 0; i < sent3.length; i++) {
        sentence3.add(new TaggedWord(sent3[i], tag3[i]));
      }
      Tree parse = lp.parse(sentence3);
      parse.pennPrint();

      List<List<? extends HasWord>> tmp =
              new ArrayList<>();
      tmp.add(sentence);
      tmp.add(sentence2);
      tmp.add(sentence3);
      sentences = tmp;
    }

    for (List<? extends HasWord> sentence : sentences) {
      Tree parse = lp.parse(sentence);
      parse.pennPrint();
      System.out.println();
      GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
      List<TypedDependency> tdl = gs.typedDependenciesCCprocessed();
      System.out.println(tdl);
      System.out.println();

      System.out.println("The words of the sentence:");
      for (Label lab : parse.yield()) {
        if (lab instanceof CoreLabel) {
          System.out.println(((CoreLabel) lab).toString(CoreLabel.OutputFormat.VALUE_MAP));
        } else {
          System.out.println(lab);
        }
      }
      System.out.println();
      System.out.println(parse.taggedYield());
      System.out.println();

    }

    // This method turns the String into a single sentence using the
    // default tokenizer for the TreebankLanguagePack.
    String sent3 = "This is one last test!";
    lp.parse(sent3).pennPrint();
  }

  private ParserDemo2() {} // static methods only

}
