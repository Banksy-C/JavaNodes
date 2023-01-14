package com.banksy.streamLambda.lecture;

import com.google.common.collect.ImmutableList;

import java.util.Comparator;
import java.util.List;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/14 12:37 PM
 **/
public class Lecture03MaxMinComparator {
    public static void main(String[] args) {
        Lecture03MaxMinComparator lecture03MaxMin = new Lecture03MaxMinComparator();
        lecture03MaxMin.maxMinComparator();
    }

    public void maxMinComparator() {
        final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

        System.out.print("最大、最小值：");
        Integer max = numbers.stream()
                .max(Comparator.naturalOrder())
                .get();
        System.out.print(max + "、");

        Integer min = numbers.stream()
                .min(Comparator.naturalOrder())
                .get();
        System.out.println(min);
    }
}