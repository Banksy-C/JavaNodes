package com.banksy.Generics.GenericsStructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何自定义泛型结构：泛型类、泛型接口；泛型方法。
 * 1.泛型的声明
 * interface List<T> 和 class GenTest<K,V>
 * 其中， T,K,V不代表值，而是表示类型。 这里使用任意字母都可以。
 * 常用T表示，是Type的缩写
 *
 * 2.泛型的实例化：
 * 一定要在类名后面指定类型参数的值（类型）。
 * 如：List<String> strList = new ArrayList<String>(); Iterator<Customer> iterator = customers.iterator();
 * T只能是类，不能用基本数据类型填充。但可以使用包装类填充
 * 把一个集合中的内容限制为一个特定的数据类型，这就是generics背后的核心思想
 *
 *
 * 一. 关于自定义泛型类、泛型接口：
 *  1. 泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如：<E1,E2,E3>
 * 2. 泛型类的构造器如下： public GenericClass(){}。而下面是错误的： public GenericClass<E>(){}
 * 3. 实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致。
 * 4. 泛型不同的引用不能相互赋值。
 * >尽管在编译时ArrayList<String>和ArrayList<Integer>是两种类型，但是，在运行时只有一个ArrayList被加载到JVM中。
 * 5. 泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价于Object。 经验： 泛型要使用一路都用。要不用，一路都不要用。
 * 6. 如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象。
 * 7. jdk1.7，泛型的简化操作： ArrayList<Fruit> flist = new ArrayList<>();
 * 8. 泛型的指定中不能使用基本数据类型，可以使用包装类替换。
 * 9. 在类/接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为非静态属性的类型、非静态方法的参数类型、非静态方法的返回值类型。但在静态方法中不能使用类的泛型。
 * 10. 异常类不能是泛型的
 * 11. 不能使用new E[]。但是可以： E[] elements = (E[])new Object[capacity];
 * 参考： ArrayList源码中声明： Object[] elementData， 而非泛型参数类型数组。
 * 12.父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型：
 *    子类不保留父类的泛型：按需实现
 *          没有类型 擦除
 *          具体类型
 *    子类保留父类的泛型：泛型子类
 *          全部保留
 *          部分保留
 * 结论：子类必须是“富二代”，子类除了指定或保留父类的泛型，还可以增加自己的泛型
 *
 *
 * @Author banksy
 * @Data 2022/9/21 10:16 PM
 * @Version 1.0
 **/
public class GenericsTest {

    @Test
    public void test1(){
        GenericsClass gc = new GenericsClass();//如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        gc.setOrderT(123);
        gc.setOrderT("ABC");

        //建议：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        GenericsClass<String> gc1 = new GenericsClass<String>("orderAA",1001,"order:AA");
        gc1.setOrderT("AA:hello");
    }

    @Test
    public void test2(){
        SubGenericsClass sub1 = new SubGenericsClass();
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        sub1.setOrderT(1122);//参数是Integer类型

        SubGenericsClass1<String> sub2 = new SubGenericsClass1<>();
        //由于子类在继承带泛型的父类时，未指明了泛型类型。则实例化子类对象时，需要指明泛型。
        sub2.setOrderT("order2...");//参数是String类型

    }

    @Test
    public void test3(){
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //泛型不同的引用不能相互赋值。
//        list1 = list2;
        NuGenerics p1 = null;
        NuGenerics p2 = null;
        p1 = p2;
    }

    /** 测试泛型方法 **/
    @Test
    public void test4(){
        GenericsClass<String> gc = new GenericsClass<>();
        Integer[] arr = new Integer[]{1,2,3,4};

        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> list = gc.copyFromArrayToList(arr);

        System.out.println(list);
    }
}


