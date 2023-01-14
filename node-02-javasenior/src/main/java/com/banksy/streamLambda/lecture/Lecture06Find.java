package com.banksy.streamLambda.lecture;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/14 2:38 PM
 **/
public class Lecture06Find {
    public static void main(String[] args) {
        Lecture06Find lecture06Find = new Lecture06Find();
        lecture06Find.find();
    }
    public void find() {
        final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("findFirst；返回流中的第一个元素；如果流是空的，则返回空；若流没有顺序，则可返回任何元素");
        int first = Arrays.stream(numbers)
                .filter(numbersLessThan10)
                .findFirst()
                .get();
        System.out.println(first);

        System.out.println("findAny：返回流中的某些元素；如果流是空的，则返回空；该操作是已知的非确定性，");
        int any = Arrays.stream(numbers)
                .filter(numbersLessThan10)
                .findAny()
                .get();
        System.out.println(any);

        System.out.println("如果需要稳定的结果，请使用findFirst()");
    }
}