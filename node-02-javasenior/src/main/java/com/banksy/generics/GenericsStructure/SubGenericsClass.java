package com.banksy.generics.GenericsStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个类继承泛型类：SubGenericsClass:不是泛型类
 *
 * @Author banksy
 * @Data 2022/9/21 10:42 PM
 * @Version 1.0
 **/
public class SubGenericsClass extends GenericsClass<Integer> {
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}