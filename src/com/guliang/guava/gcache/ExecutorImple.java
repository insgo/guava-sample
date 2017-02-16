package com.guliang.guava.gcache;

import java.util.concurrent.Executor;

/**
 * Created by HuangHailiang on 2017/2/15.
 */
public class ExecutorImple implements Executor {
    @Override
    public void execute(Runnable command) {
        System.out.println("Running ExecutorImple");
    }
}
