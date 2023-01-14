package com.banksy.streamLambda.lecture;

import java.util.Arrays;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/14 3:22 PM
 **/
public class Lecture09Reduce {
    public static void main(String[] args) {
        Lecture09Reduce lecture09Reduce = new Lecture09Reduce();
        lecture09Reduce.reduce();
    }
    public void reduce() {
        Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        System.out.println("reduce[将流中数据累计减少元素操作]：");

        int sum = Arrays.stream(integers)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        System.out.println("从0开始，向后累加：");
        int sum2 = Arrays.stream(integers)
                .reduce(0, Integer::sum);
        System.out.println(sum2);
    }
}