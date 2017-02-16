package com.guliang.guava.gcache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

/**
 * Created by HuangHailiang on 2017/2/15.
 */
public class GuavaCache {
    @Test
    public  void testCache(){

//        LoadingCache<Key, Graph> graphs = CacheBuilder.newBuilder()
//                .maximumSize(1000)
//                .expireAfterWrite(10, TimeUnit.MINUTES)
//                .removalListener(MY_LISTENER)
//                .build(new CacheLoader<Key, Graph>() {
//            public Graph load(Key key) throws AnyException {
//                return createExpensiveGraph(key);
//            }
//        });

        /**
         * 通常来说，Guava Cache适用于：
         * 你愿意消耗一些内存空间来提升速度。
         * 你预料到某些键会被查询一次以上。
         * 缓存中存放的数据总量不会超出内存容量。
         * （Guava Cache是单个应用运行时的本地缓存。它不把数据存放到文件或外部服务器。如果这不符合你的需求，请尝试Memcached这类工具）
         */

        /**
         * Cache实例通过CacheBuilder生成器模式获取
         *
         * 注：如果你不需要Cache中的特性，使用ConcurrentHashMap有更好的内存效率——但Cache的大多数特性都很难基于旧有的ConcurrentMap复制，甚至根本不可能做到
         *
         *
         */

    }
}
