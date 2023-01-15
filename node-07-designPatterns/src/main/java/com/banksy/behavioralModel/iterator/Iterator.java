package com.banksy.behavioralModel.iterator;

import java.util.Vector;

/**
 * 迭代器模式
 * Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
 * 它提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节。
 *
 * 角色：抽象迭代器【负责定义访问和遍历元素的接口， 而且基本上是有固定的3个方法 [first()获得第一个元素， next()访问下一个元素， isDone()是否已经访问到底部]】；
 *      具体迭代器【实现迭代器接口， 完成容器元素的遍历】；
 *      抽象容器【负责提供创建具体迭代器角色的接口， 必然提供一个类似createIterator()这样的方法】；
 *      具体容器【实现容器接口定义的方法， 创建出容纳迭代器的对象】；
 *
 **/
class IteratorClient {
    public static void main(String[] args) {
        //声明容器
        ConcreteAggregate agg = new ConcreteAggregate();
        //产生对象数据放进去
        agg.add("abc");
        agg.add("aaa");
        agg.add("123456");
        //遍历
        Iterator iterator = agg.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

//抽象迭代器
public interface Iterator {
    //遍历到下一个元素
    public Object next();
    //是否已经遍历到尾部
    public boolean hasNext();
    //删除当前指向到元素
    public boolean remove();
}
//具体迭代器
class ConcreteIterator implements Iterator {
    private Vector vector = new Vector();
    public int cursor = 0;

    public ConcreteIterator(Vector vector) {
        this.vector = vector;
    }

    @Override
    public Object next() {
        Object result = null;
        if (this.hasNext()) {
            result = this.vector.get(this.cursor++);
        }else {
            result = null;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        if (this.cursor == this.vector.size()) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean remove() {
        this.vector.remove(this.cursor);
        return true;
    }
}

//抽象容器
interface Aggregate {
    //是容器必然有元素的增加
    public void add(Object obj);
    //减少元素
    public void remove(Object obj);
    //由迭代器来遍历所有的元素
    public Iterator iterator();
}
//具体容器
class ConcreteAggregate implements Aggregate {
    private Vector vector = new Vector();
    @Override
    public void add(Object obj) {
        this.vector.add(obj);
    }

    @Override
    public void remove(Object obj) {
        this.vector.remove(obj);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this.vector);
    }
}