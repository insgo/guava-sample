package com.guliang.guava.iconcurrent;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Created by HuangHailiang on 2017/2/15.
 */
public class FutureTest {

    /**
     * 我们强烈地建议你在代码中多使用ListenableFuture来代替JDK的 Future, 因为
     * 大多数Futures 方法中需要它。
     * 转到ListenableFuture 编程比较容易。
     * Guava提供的通用公共类封装了公共的操作方方法，不需要提供Future和ListenableFuture的扩展方法
     *
     */

    //创建ListenableFuture
    ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

    ListenableFuture explosion = service.submit(new Callable() {
        @Override
        public Explosion call() throws Exception {
            return new Explosion("hello");
        }
    });



}
