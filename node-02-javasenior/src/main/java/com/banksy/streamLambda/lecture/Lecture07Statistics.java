package com.banksy.streamLambda.lecture;

import com.banksy.streamLambda.bean.Car;
import com.banksy.streamLambda.mockdata.MockData;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/14 2:57 PM
 **/
public class Lecture07Statistics {
    //统计数字
    public static void main(String[] args) throws IOException {
        Lecture07Statistics lecture07Statistics = new Lecture07Statistics();
        lecture07Statistics.statistics();
    }

    public void statistics() throws IOException {

        System.out.print("【count】计算性别是female的数量：");
        long count = MockData.getPeople()
                .stream()
                .filter(person -> person.getGender().equalsIgnoreCase("female"))
                .count();
        System.out.println(count);

        System.out.print("【min】汽车颜色是yellow，价格最低的是：");
        double min = MockData.getCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0);
        System.out.println(min);

        System.out.print("【max】汽车颜色是yellow，价格最高的是：");
        double max = MockData.getCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);
        System.out.println(max);

        System.out.print("【average】所有车辆价格的平均值：");
        List<Car> cars = MockData.getCars();
//    ImmutableList<Car> cars = ImmutableList.of();
        double averagePrice = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(averagePrice);

        System.out.print("【sum】所有车辆价格的和：");
        double sum = cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();
        BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
        System.out.println(sum + " == " + bigDecimalSum);


        System.out.println("【statistics】什么都有的统计函数：");
        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();
        System.out.println(statistics);
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(BigDecimal.valueOf(statistics.getSum()));
    }
}