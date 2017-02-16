package com.guliang.guava.hfunction;

import com.google.common.base.Predicate;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by HuangHailiang on 2017/2/15.
 */
public class GavaFunction {

    @Test
    public void testFunction(){
        List<Person> person = newArrayList(new Person("shasa",18),
                new Person("harley",20),
                new Person("eliam",18));

        System.out.println("personList:"+person);

    }



}
