package com.banksy.streamLambda.lecture;

import com.google.common.collect.ImmutableList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/14 12:42 PM
 **/
public class Lecture04Distinct {
    public static void main(String[] args) {
        Lecture04Distinct lecture04Distinct = new Lecture04Distinct();
        lecture04Distinct.distinct();
    }

    public void distinct() {
        final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        System.out.print("去重：");
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);

        System.out.print("去重[set]：");
        Set<Integer> distinctSetNumbers = numbers
                .stream()
                .collect(Collectors.toSet());
        System.out.println(distinctSetNumbers);

        System.out.print("去重[HashSet]：");
        Set<Integer> distinctHashSetNumbers = new HashSet<>(numbers);
        System.out.println(distinctHashSetNumbers);
    }
}