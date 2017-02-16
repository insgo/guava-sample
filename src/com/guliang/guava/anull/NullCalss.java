package com.guliang.guava.anull;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import org.junit.Test;


/**
 * Created by HuangHailiang on 2017/2/14.
 */
public class NullCalss {
    @Test
    public void nullTest() {
        boolean a = true;
        String b = "shasha";
        Preconditions.checkArgument(a);
        System.out.println("---");
        Preconditions.checkNotNull(b);

        /**
         * Null的处理
         **/
        // 使用一个不为null的值创建Optional实例
        Optional<Integer> integerOptional = Optional.of(5);
        // 判断值不为null
        System.out.println(integerOptional.isPresent()); // true
        // 获取integerOptional代表的值
        System.out.println(integerOptional.get());

        // 创建一个null的Optional实例
        Optional optional = Optional.absent();
        System.out.println(optional.isPresent()); // false

        Long longVal = null;
        // 创建失败，Optional.of(T) 参数不能为null
        //Optional<Long> longOptional = Optional.of(longVal);

        // 使用Optional.fromNullable创建 Optional实例，参数可为null，也可不为null
        Optional<Long> longOptional = Optional.fromNullable(longVal);
        System.out.println(longOptional.isPresent());

        //System.out.println(longOptional.get()); // 报错 longOptional为null
        // 返回optional的值，如optional为null返回给定的值
        System.out.println(longOptional.or(0l));
        // 返回optional的值，如optional为null返回null
        System.out.println(longOptional.orNull());

        // 总结：
        /**
         * Optional对象只需要记住三个重要的方法就可以了
         * 1. Optional<Long> longOptional = Optional.fromNullable(longVal);
         * 2. longOptional.isPresent()
         * 3. longOptional.or(T) 或 longOptional.orNull()
         */
    }
}
