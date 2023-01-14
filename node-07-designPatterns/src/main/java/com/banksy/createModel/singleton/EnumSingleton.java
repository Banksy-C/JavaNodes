package com.banksy.createModel.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举式单例模式
 * @author banksy
 **/
public enum EnumSingleton {

    INSTANCE;

    //在枚举类中声明一个新的成员变量，才能实现扩展
    private Object data;

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

}

class ReflectionBreakEnumSingleton{
    public static void main(String[] args) {
        try {
            EnumSingleton instance = EnumSingleton.INSTANCE;
            System.out.println(instance);

            Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
            declaredConstructor.setAccessible(true);
            EnumSingleton instance1 = declaredConstructor.newInstance();
            System.out.println(instance1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}