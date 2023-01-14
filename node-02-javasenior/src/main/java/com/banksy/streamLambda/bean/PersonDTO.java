package com.banksy.streamLambda.bean;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/13 9:26 PM
 **/
public class PersonDTO {
    private final Integer id;
    private final String name;
    private final Integer age;

    public PersonDTO(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static PersonDTO map(Person person) {
        return new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
    }
}