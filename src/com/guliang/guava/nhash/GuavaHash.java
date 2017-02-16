package com.guliang.guava.nhash;

import com.google.common.base.Charsets;
import com.google.common.hash.*;
import com.guliang.guava.hfunction.*;
import org.junit.Test;

/**
 * Created by HuangHailiang on 2017/2/15.
 */
public class GuavaHash {
    @Test
    public void testHash(){

        Person person = new Person(12,"Huang","hailiang",21);

        Funnel<Person> personFunnel = new Funnel<Person>() {//Funnel描述了如何把一个具体的对象类型分解为原生字段值，从而写入PrimitiveSink
            @Override
            public void funnel(Person person, PrimitiveSink into) {
                into.putInt(person.id)
                        .putString(person.firstName, Charsets.UTF_8)
                        .putString(person.lastName,Charsets.UTF_8)
                        .putInt(person.birthYear);
            }
        };

        HashFunction hf = Hashing.md5();
        HashCode hc =hf.newHasher().putLong(person.getId())
                .putObject(person,personFunnel).hash();

        System.out.println(hc);
    }
}
