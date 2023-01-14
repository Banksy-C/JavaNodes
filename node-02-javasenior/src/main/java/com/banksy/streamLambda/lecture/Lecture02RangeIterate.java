package com.banksy.streamLambda.lecture;

import com.google.common.collect.ImmutableList;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/14 12:02 PM
 **/
public class Lecture02RangeIterate {
    public static void main(String[] args) {
        Lecture02RangeIterate lecture02RangeIterate = new Lecture02RangeIterate();
        lecture02RangeIterate.RangeIterate();
    }

    public void RangeIterate() {

        System.out.print("范围输出[开区间]：");
        IntStream.range(0, 10).forEach(value -> System.out.print(value + "、"));
        System.out.println();

        System.out.print("范围输出[闭区间]：");
        IntStream.rangeClosed(0, 10).forEach(value -> System.out.print(value + "、"));
        System.out.println();

        System.out.print("迭代器：");
        IntStream.iterate(0, operand -> operand + 1)
                .filter(number -> number % 2 == 0)
                .limit(20)
                .forEach(value -> System.out.print(value + "、"));
        System.out.println();
    }
}