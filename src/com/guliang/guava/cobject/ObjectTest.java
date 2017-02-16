package com.guliang.guava.cobject;

import com.google.common.collect.ComparisonChain;
import org.junit.Test;

import java.util.Objects;

/**
 * Created by HuangHailiang on 2017/2/14.
 */
public class ObjectTest {
    @Test
    public void objectTest() {
        /**
         * equals
         * 当一个对象中的字段可以为null时，实现Object.equals方法会很痛苦，
         * 因为不得不分别对它们进行null检查。
         * 使用Objects.equal帮助你执行null敏感的equals判断，
         * 从而避免抛出NullPointerException
         */
        System.out.println(Objects.equals("a", "a"));
        System.out.println(Objects.equals(null, "a"));
        System.out.println(Objects.equals("a", null));
        System.out.println(Objects.equals(null, null));

    }

    @Test
    public void objectHashcode() {
        /**
         * hashCode
         * 用对象的所有字段作散列[hash]运算应当更简单。
         * Guava的Objects.hashCode(Object...)会对传入的字段序列计算出合理的、
         * 顺序敏感的散列值
         */
        System.out.println(Objects.hash("age", "name", "sex"));
    }

    @Test
    public void objectToString() {
        /**
         * 好的toString方法在调试时是无价之宝，但是编写toString方法有时候却很痛苦
         */
        System.out.println(Objects.toString("age"));

    }

    @Test
    public void objectCompare() {
        Person p1 = new Person(12,"shasa","123");
        Person p2 = new Person(15,"harley","456");

        /**
         * 实现一个比较器[Comparator]，或者直接实现Comparable接口有时也伤不起
         *
         * 输出的结果为一个int类型，也就是比较的最终结果，还需要进行排列
         */
         System.out.println(ComparisonChain.start().compare(p1.getAge(),p2.getAge()).compare(p1.getName(),p2.getName()).result());


    }
}
