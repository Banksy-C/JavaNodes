package com.banksy.Generics.GenericsStructure.example;

import org.junit.Test;

import java.util.List;

/**
 * DAO：表的共性操作的DAO
 * CustomerDAO【extends DAO<Customer>】：只能操作某一个表的DAO
 * StudentDAO【extends DAO<Student>】：只能操作某一个表的DAO
 *
 * 相当于Customer是实体类，而CustomerDAO是操作数据库对应的一张表，但方法都继承于DAO；
 * @author shkstart
 * @create 2019 上午 11:57
 */
public class DAOTest {

    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);

        StudentDAO dao2 = new StudentDAO();
        Student student = dao2.getIndex(1);
    }
}
