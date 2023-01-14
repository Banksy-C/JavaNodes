package com.banksy.streamLambda.lecture;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/14 3:31 PM
 **/
public class Lecture10FlatMap {
    public static void main(String[] args) {
        Lecture10FlatMap lecture10FlatMap = new Lecture10FlatMap();
        lecture10FlatMap.flatMap();
    }

    private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
            Lists.newArrayList("Mariam", "Alex", "Ismail"),
            Lists.newArrayList("John", "Alesha", "Andre"),
            Lists.newArrayList("Susy", "Ali")
    );

    public void flatMap() {
        System.out.println("将多个数组，转为一个数组：");

        System.out.println("非stream写法：");
        List<String> names = Lists.newArrayList();
        for(List<String> listOfNames : arrayListOfNames) {
            for(String name : listOfNames) {
                names.add(name);
            }
        }
        System.out.println(names);


        System.out.println("stream写法：");
        List<String> streamNames = arrayListOfNames.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(streamNames);
    }
}