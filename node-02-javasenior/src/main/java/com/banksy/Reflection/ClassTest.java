package com.banksy.Reflection;

import com.banksy.Reflection.other.Person;
import org.junit.Test;

import java.lang.annotation.ElementType;

/**
 * 【理解Class类并获取Class实例】
 *
 * @Author banksy
 * @Data 2022/10/3 4:03 PM
 * @Version 1.0
 **/
public class ClassTest {
    /**
     关于java.lang.Class类的理解
     1.类的加载过程：
     程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。--编译
     接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程就称为类的加载。
     加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class的一个实例。

     2.换句话说，Class的实例就对应着一个运行时类。
     3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类。
     **/

    /** 获取Class的实例的方式（前三种方式需要掌握）**/
    @Test
    public void test1() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        //若已知具体的类，通过类的class属性获取， 该方法最为安全可靠，程序性能最高
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象,调用getClass()
        //已知某个类的实例，调用该实例的getClass()方法获取Class对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        //已知一个类的全类名，且该类在类路径下， 可通过Class类的静态方法forName()获取，可能抛出ClassNotFoundException
        Class clazz3 = Class.forName("com.banksy.Reflection.other.Person");
//        clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        //方式四：使用类的加载器：ClassLoader  (了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.banksy.Reflection.other.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz4);
    }

    //万事万物皆对象？对象.xxx,File,URL,反射,前端、数据库操作

    //Class实例可以是哪些结构的说明：
    @Test
    public void test2(){
        Class c1 = Object.class;//对象
        Class c2 = Comparable.class;//接口
        Class c3 = String[].class;//数组
        Class c4 = int[][].class;//二维数组
        Class c5 = ElementType.class;//枚举类
        Class c6 = Override.class;//注解
        Class c7 = int.class;//基本数据类型
        Class c8 = void.class;//返回值
        Class c9 = Class.class;//Class本身

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }
}