package com.guliang.guava.jstring;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by HuangHailiang on 2017/2/15.
 */
public class TestString {
    @Test
    public void testString() {
        /**
         * 可用过滤掉null的字符串的拼接
         */

        /**
         * Splitter.on(char)	按单个字符拆分
         * Splitter.on(‘;’)
         *
         * Splitter.on(CharMatcher)	按字符匹配器拆分
         * Splitter.on(CharMatcher.BREAKING_WHITESPACE)
         *
         * Splitter.on(String)	按字符串拆分
         * Splitter.on(“,   “)
         *
         * Splitter.on(Pattern) Splitter.onPattern(String)	按正则表达式拆分
         * Splitter.onPattern(“\r?\n”)
         *
         * Splitter.fixedLength(int)	按固定长度拆分；最后一段可能比给定长度短，但不会为空。
         * Splitter.fixedLength(3)
         */

        Joiner joiner = Joiner.on(";").skipNulls();
        System.out.println(joiner.join("harley", null, "rose", 1));

        System.out.println("\n");

        System.out.println(Joiner.on(",").join(Arrays.asList(1, 5, 3, 7)));

        String[] split = ",a,,b,".split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        //返回的居然是"","a","","b"

        System.out.println("\n");

        /**
         omitEmptyStrings()	从结果中自动忽略空字符串
         trimResults()	移除结果字符串的前导空白和尾部空白
         trimResults(CharMatcher)	给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
         limit(int)	限制拆分出的字符串数量
         */
        System.out.println(Splitter.on(',').trimResults().omitEmptyStrings().split("foo,bar,,   qux"));


        /**
         * 如果你想要拆分器返回List，只要使用Lists.newArrayList(splitter.split(string))或类似方法。
         * 警告：splitter实例总是不可变的。
         * 用来定义splitter目标语义的配置方法总会返回一个新的splitter实例。
         * 这使得splitter实例都是线程安全的，你可以将其定义为static final常量
         */

        /**
         * 使用CharMatcher的好处更在于它提供了一系列方法，
         * 让你对字符作特定类型的操作：修剪[trim]、折叠[collapse]、移除[remove]、保留[retain]等等
         */
        String string = "i want to control 1 and 2 everything";
        String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(string);
        System.out.println(noControl);

        String theDigits = CharMatcher.DIGIT.retainFrom(string); //只保留数字字符
        System.out.println(theDigits);

        String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(string, ' ');//去除两端的空格，并把中间的连续空格替换成单个空格
        System.out.println(spaced);

        String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(string, "*"); //用*号替换所有数字
        System.out.println(noDigits);

        String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(string);// 只保留数字和小写字母
        System.out.println(lowerAndDigit);

        String constant_name = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "hahha HHHH CONSTANT_NAME");// returns "constantName"
        System.out.println(constant_name);

    }
}
