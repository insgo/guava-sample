package com.guliang.guava.lrange;

import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.BoundType.CLOSED;
import static com.google.common.collect.BoundType.OPEN;

/**
 * Created by HuangHailiang on 2017/2/15.
 */
public class TestRange {
    @Test
    public void testRange() {
        List<Integer> scores = Lists.newArrayList(5, 60, 77, 80);

        Iterable belowMedian = Iterables.filter(scores, Range.lessThan(70));
        System.out.println(belowMedian);//[5, 60]

        /**
         * 构建区间
         区间实例可以由Range类的静态方法获取：

         (a..b)	open(C, C)
         [a..b]	closed(C, C)
         [a..b)	closedOpen(C, C)
         (a..b]	openClosed(C, C)
         (a..+∞)	greaterThan(C)
         [a..+∞)	atLeast(C)
         (-∞..b)	lessThan(C)
         (-∞..b]	atMost(C)
         (-∞..+∞)	all()
         */

        System.out.println(Range.closed("left", "right"));
        System.out.println(Range.closed(60, 80));
        System.out.println(Range.open(60, 80));

        /**
         * 此外，也可以明确地指定边界类型来构造区间：

         有界区间	range(C, BoundType, C,   BoundType)
         无上界区间：((a..+∞) 或[a..+∞))	downTo(C, BoundType)
         无下界区间：((-∞..b) 或(-∞..b])	upTo(C, BoundType)
         */

        System.out.println(Range.downTo(4, CLOSED));// (a..+∞)或[a..+∞)，取决于boundType
        System.out.println(Range.range(1, CLOSED, 4, OPEN));// [1..4)，等同于Range.closedOpen(1, 4)


        /**
         * Range的基本运算是它的contains(C) 方法，和你期望的一样，它用来区间判断是否包含某个值
         */
        System.out.println(Range.closed(1, 3).contains(2));//return true
        System.out.println(Range.closed(1, 3).contains(4));//return false
        System.out.println(Range.lessThan(5).contains(5)); //return false
        System.out.println(Range.closed(1, 4).containsAll(Ints.asList(1, 2, 3))); //return true


        /**查询运算

         Range类提供了以下方法来 查看区间的端点：

         hasLowerBound()和hasUpperBound()：判断区间是否有特定边界，或是无限的；
         lowerBoundType()和upperBoundType()：返回区间边界类型，CLOSED或OPEN；如果区间没有对应的边界，抛出IllegalStateException；
         lowerEndpoint()和upperEndpoint()：返回区间的端点值；如果区间没有对应的边界，抛出IllegalStateException；
         isEmpty()：判断是否为空区间。
         **/
        Range.closedOpen(4, 4).isEmpty(); // returns true
        Range.openClosed(4, 4).isEmpty(); // returns true
        Range.closed(4, 4).isEmpty(); // returns false
        //Range.open(4, 4).isEmpty(); // Range.open throws IllegalArgumentException
        Range.closed(3, 10).lowerEndpoint(); // returns 3
        Range.open(3, 10).lowerEndpoint(); // returns 3
        Range.closed(3, 10).lowerBoundType(); // returns CLOSED
        Range.open(3, 10).upperBoundType(); // returns OPEN


        /**
         * 关系运算

         包含[enclose]
         区间之间的最基本关系就是包含[encloses(Range)]：


         相连[isConnected]
         Range.isConnected(Range)判断区间是否是相连的

         交集[intersection]
         Range.intersection(Range)返回两个区间的交集：既包含于第一个区间，又包含于另一个区间的最大区间

         跨区间[span]
         Range.span(Range)返回”同时包括两个区间的最小区间

         */
        boolean encloses = Range.closed(3, 8).isConnected(Range.closed(8, 21));
        System.out.print(encloses);


        /**
         * 离散域
         部分（但不是全部）可比较类型是离散的，即区间的上下边界都是可枚举的。

         在Guava中，用DiscreteDomain<C>实现类型C的离散形式操作。一个离散域总是代表某种类型值的全集；它不能代表类似”素数”、”长度为5的字符串”或”午夜的时间戳”这样的局部域。

         DiscreteDomain提供的离散域实例包括：

         类型	离散域
         Integer	integers()
         Long	longs()
         一旦获取了DiscreteDomain实例，你就可以使用下面的Range运算方法：

         ContiguousSet.create(range, domain)：用ImmutableSortedSet<C>形式表示Range<C>中符合离散域定义的元素，并增加一些额外操作——译者注：实际返回ImmutableSortedSet的子类ContiguousSet。（对无限区间不起作用，除非类型C本身是有限的，比如int就是可枚举的）
         canonical(domain)：把离散域转为区间的”规范形式”。如果ContiguousSet.create(a, domain).equals(ContiguousSet.create(b, domain))并且!a.isEmpty()，则有a.canonical(domain).equals(b.canonical(domain))。（这并不意味着a.equals(b)）
         **/
        //ImmutableSortedSet set = ContigousSet.create(Range.open(1, 5), iscreteDomain.integers());
        // set包含[2, 3, 4]
        ContiguousSet.create(Range.greaterThan(0), DiscreteDomain.integers());
        //set包含[1, 2, ..., Integer.MAX_VALUE]
        /**
         注意，ContiguousSet.create并没有真的构造了整个集合，而是返回了set形式的区间视图。
         */
    }
}
