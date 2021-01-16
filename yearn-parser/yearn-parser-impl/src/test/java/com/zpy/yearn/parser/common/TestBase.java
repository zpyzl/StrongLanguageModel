package com.zpy.yearn.parser.common;

import com.zpy.yearn.parser.StanfordParserApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zpy on 2018/9/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StanfordParserApplication.class )
public class TestBase {

    public static void print(Object s){
        System.out.print(s.toString());
    }
    public static void println(Object s){
        System.out.println(s.toString());
    }
}
