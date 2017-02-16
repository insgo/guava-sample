package com.guliang.guava.oreflection;

import com.google.common.reflect.TypeToken;
import org.junit.Test;

import java.util.List;

/**
 * Created by HuangHailiang on 2017/2/15.
 */
public class TestReflection {
    @Test
    public void testReflection(){
        //获取一个基本的、原始类的TypeToken
        TypeToken<String> stringTok = TypeToken.of(String.class);
        System.out.println(stringTok);

        //为获得一个含有泛型的类型的TypeToken —— 当你知道在编译时的泛型参数类型 —— 你使用一个空的匿名内部类：
        //TypeToken<List<String>> stringListTok = new TypeToken<List<String>>() {};


        /**
         * 查询
         TypeToken支持很多种类能支持的查询，但是也会把通用的查询约束考虑在内。

         支持的查询操作包括：
         getType()	获得包装的java.lang.reflect.Type.
         getRawType()	返回大家熟知的运行时类
         getSubtype(Class<?>)	返回那些有特定原始类的子类型。举个例子，如果这有一个Iterable并且参数是List.class，那么返回将是List。
         getSupertype(Class<?>)	产生这个类型的超类，这个超类是指定的原始类型。举个例子，如果这是一个Set并且参数是Iterable.class，结果将会是Iterable。
         isAssignableFrom(type)	如果这个类型是 assignable from 指定的类型，并且考虑泛型参数，返回true。List<? extends Number>是assignable from List，但List没有.
         getTypes()	返回一个Set，包含了这个所有接口，子类和类是这个类型的类。返回的Set同样提供了classes()和interfaces()方法允许你只浏览超类和接口类。
         isArray()	检查某个类型是不是数组，甚至是<? extends A[]>。
         getComponentType()	返回组件类型数组。
         */
        System.out.println("getType>>"+stringTok.getType());
        System.out.println("getRawType>>"+stringTok.getRawType());
        //System.out.print("getSubtype>>>"+stringTok.getSubtype());
        //System.out.print("getSupertype>>>"+stringTok.getSupertype());
        System.out.println("isArray>>>"+stringTok.isArray());
        System.out.println("getTypes>>>"+stringTok.getTypes());
        System.out.println("getComponentType>>>"+stringTok.getComponentType());
    }

}
