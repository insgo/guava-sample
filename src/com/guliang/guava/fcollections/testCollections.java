package com.guliang.guava.fcollections;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
import org.junit.Test;

import java.awt.*;
import java.util.Set;

/**
 * Created by HuangHailiang on 2017/2/14.
 */
public class testCollections {

    @Test

    public void testUnmodifiableCollection() {
        /**
         * 为什么要使用不可变集合
         不可变对象有很多优点，包括：

         当对象被不可信的库调用时，不可变形式是安全的；
         不可变对象被多个线程调用时，不存在竞态条件问题
         不可变集合不需要考虑变化，因此可以节省时间和空间。所有不可变的集合都比它们的可变形式有更好的内存利用率（分析和测试细节）；
         不可变对象因为有固定不变，可以作为常量来安全使用。
         创建对象的不可变拷贝是一项很好的防御性编程技巧。
         */
        ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
                "red", "orange", "yellow", "green", "blue", "purple"
        );

        //ImmutableSet<Color> GOOGLE_COLORS = ImmutableSet.builder().addAll(WEBSAFE_COLORS).add(new Color(0,191,255)).build();

        final ImmutableSortedSet<String> sortI = ImmutableSortedSet.of("a", "b", "d", "c", "b");

        System.out.println(sortI);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");

        //所有不可变集合都有一个asList()方法提供ImmutableList视图，来帮助你用列表形式方便地读取集合元素
        //asList()返回的ImmutableList通常是——并不总是——开销稳定的视图实现，而不是简单地把元素拷贝进List。也就是说，asList返回的列表视图通常比一般的列表平均性能更好，比如，在底层集合支持的情况下，它总是使用高效的contains方法
        System.out.println(sortI.asList().get(3));



    }
}
