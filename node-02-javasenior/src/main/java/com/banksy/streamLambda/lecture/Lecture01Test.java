package com.banksy.streamLambda.lecture;

import com.banksy.streamLambda.bean.Person;
import com.banksy.streamLambda.mockdata.MockData;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/13 10:12 PM
 **/
public class Lecture01Test {
    public static void main(String[] args) throws Exception {
        Lecture01Test lecture01Test = new Lecture01Test();
        lecture01Test.imperativeApproach();
        System.out.println();
        System.out.println("=========================使用stream&lambda=========================");
        lecture01Test.declarativeApproachUsingStreams();
    }

    public void imperativeApproach() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> youngPeople = Lists.newArrayList();

        final int limit = 10;
        int counter = 0;

        for( Person person : people) {
            if(person.getAge() <= 18) {
                youngPeople.add(person);
                counter++;
                if(counter == limit) {
                    break;
                }
            }
        }

        for (Person young : youngPeople) {
            System.out.println(young);
        }
    }

    public void declarativeApproachUsingStreams() throws Exception {
        MockData.getPeople()
                .stream()
                .filter(person -> person.getAge() <= 18)
                .limit(10)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}