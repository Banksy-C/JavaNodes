package com.banksy.streamLambda.lecture;

import com.banksy.streamLambda.mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/14 4:10 PM
 **/
public class Lecture12FilterAndMap {
    public static void main(String[] args) throws IOException {
        Lecture12FilterAndMap lecture12FilterAndMap = new Lecture12FilterAndMap();
        lecture12FilterAndMap.FilterAndMap();
    }
    public void FilterAndMap() throws IOException {
        System.out.println("stream流在边遍历时就在筛选，但运算是在最后：");
        List<Double> result = MockData.getCars()
                .stream()
                .filter(car -> {
                    System.out.println("filter car " + car);
                    return car.getPrice() < 10000;
                })
                .map(car -> {
                    System.out.println("mapping car " + car);
                    return car.getPrice();
                })
                .map(price -> {
                    System.out.println("mapping price " + price);
                    return price + (price * .14);
                })
                .collect(Collectors.toList());
        System.out.println(result);
    }
}