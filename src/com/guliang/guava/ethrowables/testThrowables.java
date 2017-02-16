package com.guliang.guava.ethrowables;

import com.google.common.base.Throwables;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by HuangHailiang on 2017/2/14.
 */
public class testThrowables {

    /**
     *
     * RuntimeException   propagate(Throwable)
     * 如果Throwable是Error或RuntimeException，直接抛出；否则把Throwable包装成RuntimeException抛出。返回类型是RuntimeException，所以你可以像上面说的那样写成throw Throwables.propagate(t)，Java编译器会意识到这行代码保证抛出异常。
     *
     * void propagateIfInstanceOf( Throwable, Class<X extends   Exception>) throws X
     * Throwable类型为X才抛出
     *
     * void propagateIfPossible( Throwable)
     * Throwable类型为Error或RuntimeException才抛出
     *
     * void   propagateIfPossible( Throwable, Class<X extends Throwable>) throws X
     * Throwable类型为X, Error或RuntimeException才抛出
     */
    @Test
    public void testThrowables(){
        try {
            throw new Exception();
        }catch (Throwable t){
            String ss = Throwables.getStackTraceAsString(t);
            System.out.println("ss:"+ss);
//            Throwables.propagate(t);
        }
    }

    @Test
    public void call() throws IOException {
        try {
            throw new IOException();
        } catch (Throwable t) {
            Throwables.propagateIfInstanceOf(t, IOException.class);
            throw Throwables.propagate(t);
        }
    }
}
