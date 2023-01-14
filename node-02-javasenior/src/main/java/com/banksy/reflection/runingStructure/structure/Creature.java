package com.banksy.reflection.runingStructure.structure;

import java.io.Serializable;

/**
 * @Author banksy
 * @Data 2022/10/3 6:50 PM
 * @Version 1.0
 **/
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}