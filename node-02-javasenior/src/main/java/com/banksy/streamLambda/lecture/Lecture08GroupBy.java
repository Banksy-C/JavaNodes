package com.banksy.streamLambda.lecture;

import com.banksy.streamLambda.bean.Car;
import com.banksy.streamLambda.mockdata.MockData;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/14 3:12 PM
 **/
public class Lecture08GroupBy {
    public static void main(String[] args) throws IOException {
        Lecture08GroupBy lecture08GroupBy = new Lecture08GroupBy();
        lecture08GroupBy.groupBy();
    }

    public void groupBy() throws IOException {
        System.out.println("按照汽车类型进行分组：");
        Map<String, List<Car>> grouping = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getMake));

        grouping.forEach((make, cars) -> {
            System.out.println(make);
            cars.forEach(System.out::println);
        });

        System.out.println();
        System.out.println("分组计数：");
        ArrayList<String> names = Lists
                .newArrayList(
                        "John",
                        "John",
                        "Mariam",
                        "Alex",
                        "Mohammado",
                        "Mohammado",
                        "Vincent",
                        "Alex",
                        "Alex"
                );
        Map<String, Long> counting = names
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        counting.forEach((name, count) -> System.out.println(name + " > " + count));
    }
}