package com.guliang.guava.fcollections;

import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by HuangHailiang on 2017/2/14.
 */
public class GuavaCollections {
    @Test
    public  void  guavaCollections(){
        List<Bar>  list = Lists.newArrayList();//能够推断范型的静态工厂方法
        Map<String,Integer>  map = Maps.newHashMap();

        /**
         * Guava的静态工厂方法远不止这么简单。用工厂方法模式，我们可以方便地在初始化时就指定起始元素
         */
        List<String> theseElements = Lists.newArrayList("alpha", "beta", "gamma");
        System.out.println(">>>"+theseElements);

        /**
         * 通过为工厂方法命名（Effective Java第一条），我们可以提高集合初始化大小的可读性
         */
        List<String> exactly100 = Lists.newArrayListWithCapacity(100);
        List<String> approx100 = Lists.newArrayListWithExpectedSize(100);
        Set<String> approx100Set = Sets.newHashSetWithExpectedSize(100);


        /**
         * Guava引入的新集合类型没有暴露原始构造器，也没有在工具类中提供初始化方法。而是直接在集合类中提供了静态工厂方法
         *
         */
        Multiset<String> multiset = HashMultiset.create();


        /**
         * concat(Iterable<Iterable>)	串联多个iterables的懒视图*	concat(Iterable...)
         frequency(Iterable, Object)	返回对象在iterable中出现的次数	与Collections.frequency (Collection,   Object)比较；Multiset
         partition(Iterable, int)	把iterable按指定大小分割，得到的子集都不能进行修改操作	Lists.partition(List, int)；paddedPartition(Iterable, int)
         getFirst(Iterable, T default)	返回iterable的第一个元素，若iterable为空则返回默认值	与Iterable.iterator(). next()比较;FluentIterable.first()
         getLast(Iterable)	返回iterable的最后一个元素，若iterable为空则抛出NoSuchElementException	getLast(Iterable, T default)；
         FluentIterable.last()
         elementsEqual(Iterable, Iterable)	如果两个iterable中的所有元素相等且顺序一致，返回true	与List.equals(Object)比较
         unmodifiableIterable(Iterable)	返回iterable的不可变视图	与Collections. unmodifiableCollection(Collection)比较
         limit(Iterable, int)	限制iterable的元素个数限制给定值	FluentIterable.limit(int)
         getOnlyElement(Iterable)	获取iterable中唯一的元素，如果iterable为空或有多个元素，则快速失败	getOnlyElement(Iterable, T default)
         */
        Iterable<Integer> concatenated = Iterables.concat(Ints.asList(1,2,3),Ints.asList(4,5,6));
        Integer lastAdded = Iterables.getLast(concatenated);
        System.out.println(lastAdded);

        Iterable<Integer> concatenated1 = Iterables.concat(Ints.asList(3));
        Integer onlyElement = Iterables.getOnlyElement(concatenated1);
        System.out.println(onlyElement);


        /**
         * partition(List, int)	把List按指定大小分割
         reverse(List)	返回给定List的反转视图。注: 如果List是不可变的，考虑改用ImmutableList.reverse()。
         */
        List countUp = Ints.asList(1, 2, 3, 4, 5);
        System.out.println(countUp);

        List countDown = Lists.reverse(countUp); // {5, 4, 3, 2, 1}
        System.out.println(countDown);

        List<List> parts = Lists.partition(countUp, 2);//{{1,2}, {3,4}, {5}}
        System.out.println(parts);

        /**
         *
         * Sets
         Sets工具类包含了若干好用的方法。

         集合理论方法

         我们提供了很多标准的集合运算（Set-Theoretic）方法，这些方法接受Set参数并返回SetView，可用于：

         直接当作Set使用，因为SetView也实现了Set接口；
         用copyInto(Set)拷贝进另一个可变集合；
         用immutableCopy()对自己做不可变拷贝。
         方法
         union(Set, Set)
         intersection(Set, Set)
         difference(Set, Set)
         symmetricDifference(Set,   Set)
         */

    }
}
