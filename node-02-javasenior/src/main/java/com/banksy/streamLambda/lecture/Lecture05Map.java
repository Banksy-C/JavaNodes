package com.banksy.streamLambda.lecture;

import com.banksy.streamLambda.bean.Car;
import com.banksy.streamLambda.bean.Person;
import com.banksy.streamLambda.bean.PersonDTO;
import com.banksy.streamLambda.mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/14 2:02 PM
 **/
public class Lecture05Map {
    public static void main(String[] args) throws IOException {
        Lecture05Map lecture05Map = new Lecture05Map();
        lecture05Map.Map();

    }

    public void Map() throws IOException {
        List<Person> people = MockData.getPeople();
        System.out.println("数据类型转换：");
        //括号里的map是PersonDTO中的方法
        //.map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
        List<PersonDTO> dtos = people.stream()
                .map(PersonDTO::map)
                .collect(Collectors.toList());
        dtos.forEach(System.out::println);
        System.out.println(dtos.size());
        System.out.println();

        System.out.println("=====================================================================");
        System.out.println("数据类型转换，并求平均值：");
        double average = MockData.getCars()
                .stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(average);
        System.out.println("map返回的是入参类型；mapToDouble返回DoubleStream");
    }


}