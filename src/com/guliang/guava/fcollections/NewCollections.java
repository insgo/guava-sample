package com.guliang.guava.fcollections;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HuangHailiang on 2017/2/14.
 */
public class NewCollections {

    @Test
    public  void  newCollections(){
        /**
         * count(E)	给定元素在Multiset中的计数
         elementSet()	Multiset中不重复元素的集合，类型为Set<E>
         entrySet()	和Map的entrySet类似，返回Set<Multiset.Entry<E>>，其中包含的Entry支持getElement()和getCount()方法
         add(E, int)	增加给定元素在Multiset中的计数
         remove(E, int)	减少给定元素在Multiset中的计数
         setCount(E, int)	设置给定元素在Multiset中的计数，不可以为负数
         size()	返回集合元素的总个数（包括重复的元素）



         multiset.size()返回集合的大小，等同于所有元素计数的总和。对于不重复元素的个数，应使用elementSet().size()方法
         Multiset支持直接增加、减少或设置元素的计数。setCount(elem, 0)等同于移除所有elem

         */




        Map<String,Integer> nameToId = Maps.newHashMap();
        Map<Integer,String> idToName = Maps.newHashMap();

        nameToId.put("Bob",42);
        idToName.put(42,"Bob");

        System.out.println(nameToId);
        System.out.println(idToName);

        System.out.println("\n");
         /**
         * BiMap:实现键值对的双向映射
         *
         *可以用 inverse()反转BiMap<K, V>的键值映射
         * 保证值是唯一的，因此 values()返回Set而不是普通的Collection
         *
         */
        BiMap<String ,Integer> userId = HashBiMap.create();
        userId.put("丽莎",1);
        userId.put("海良",2);
        String userForId = userId.inverse().get(1);
        System.out.println(userForId);
        Integer userName = userId.get("丽莎");
        System.out.println(userName);


        /**
         *
         * 通常来说，当你想使用多个键做索引的时候，
         * 你可能会用类似Map<FirstName, Map<LastName, Person>>的实现，
         * 这种方式很丑陋，使用上也不友好。
         * Guava为此提供了新集合类型Table，它有两个支持所有类型的键：”行”和”列”。
         * Table提供多种视图
         */
        System.out.println("\n");

        /**
         * rowMap()：用Map<R, Map<C, V>>表现Table<R, C, V>。同样的， rowKeySet()返回”行”的集合Set<R>。
         row(r) ：用Map<C, V>返回给定”行”的所有列，对这个map进行的写操作也将写入Table中。
         类似的列访问方法：columnMap()、columnKeySet()、column(c)。（基于列的访问会比基于的行访问稍微低效点）
         cellSet()：用元素类型为Table.Cell<R, C, V>的Set表现Table<R, C, V>。Cell类似于Map.Entry，但它是用行和列两个键区分的。
         */

        Table<String, String, Double> weightedGraph = HashBasedTable.create();
        weightedGraph.put("v1", "v2", 4.0);
        weightedGraph.put("v1", "v3", 20.5);
        weightedGraph.put("v2", "v3", 5.0);
        System.out.println(weightedGraph.row("v1"));
        System.out.println(weightedGraph.column("v3"));
        System.out.println(weightedGraph.rowKeySet());
        System.out.println(weightedGraph.cellSet());//[(v1,v3)=20.5, (v1,v2)=4.0, (v2,v3)=5.0]

        System.out.println("\n");
        /**
         *
         * ClassToInstanceMap是一种特殊的Map：它的键是类型，而值是符合键所指类型的对象。
         * 为了扩展Map接口，ClassToInstanceMap额外声明了两个方法：T getInstance(Class<T>) 和T putInstance(Class<T>, T)，
         * 从而避免强制类型转换，同时保证了类型安全。
         *
         */

        ClassToInstanceMap<Number> numberDefauls = MutableClassToInstanceMap.create();
        numberDefauls.putInstance(Integer.class,Integer.valueOf(5));
        System.out.println("numberDefauls"+numberDefauls);


        System.out.println("\n");

        /**
         * RangeSet
         *
         * RangeSet描述了一组不相连的、非空的区间。当把一个区间添加到可变的RangeSet时，所有相连的区间会被合并，空区间会被忽略
         */
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10)); // {[1,10]}
        System.out.println(rangeSet);

        rangeSet.add(Range.closedOpen(11, 15));//不相连区间:{[1,10], [11,15)}
        System.out.println(rangeSet);

        rangeSet.add(Range.closedOpen(15, 20)); //相连区间; {[1,10], [11,20)}
        System.out.println(rangeSet);

        rangeSet.add(Range.openClosed(0, 0)); //空区间; {[1,10], [11,20)}
        System.out.println(rangeSet);

        rangeSet.remove(Range.open(5, 10)); //分割[1, 10]; {[1,5], [10,10], [11,20)}
        System.out.println(rangeSet);


        System.out.println("\n");
        /**
         * RangeMap
         *
         *
         * RangeMap描述了”不相交的、非空的区间”到特定值的映射
         */
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo"); //{[1,10] => "foo"}
        System.out.println(rangeMap);
        rangeMap.put(Range.open(3, 6), "bar"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo"}
        System.out.println(rangeMap);
        rangeMap.put(Range.open(10, 20), "foo"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo", (10,20) => "foo"}
        System.out.println(rangeMap);
        rangeMap.remove(Range.closed(5, 11)); //{[1,3] => "foo", (3,5) => "bar", (11,20) => "foo"}
        System.out.println(rangeMap);

    }
}
