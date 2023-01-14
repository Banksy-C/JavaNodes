package com.banksy.behavioralModel.iterator;

import java.util.Vector;

/**
 * 迭代器模式
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