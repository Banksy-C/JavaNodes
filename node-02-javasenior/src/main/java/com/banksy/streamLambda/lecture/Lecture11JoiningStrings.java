package com.banksy.streamLambda.lecture;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/14 3:37 PM
 **/
public class Lecture11JoiningStrings {
    public static void main(String[] args) {
        Lecture11JoiningStrings lecture11JoiningStrings = new Lecture11JoiningStrings();
        lecture11JoiningStrings.joiningStrings();
    }
    public void joiningStrings() {
        System.out.println("将逗号把字符串连接在一起：");

        System.out.println("非stream写法：");
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
        String join = "";
        for(String name : names) {
            join += name + ", ";
        }
        System.out.println(join.substring(0, join.length()-2));



        System.out.println("stream写法：");
        join = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining("|"));
        System.out.println(join);
    }
}