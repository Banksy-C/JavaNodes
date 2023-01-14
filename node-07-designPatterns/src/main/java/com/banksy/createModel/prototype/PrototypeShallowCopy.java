package com.banksy.createModel.prototype;

import java.util.Date;

/**
 * 浅拷贝
 * @author banksy
 **/
public class PrototypeShallowCopy implements Cloneable {
    private String name;
    private Date createTime;

    @Override
    protected PrototypeShallowCopy clone() {
        PrototypeShallowCopy prototypeShallowCopy = null;
        try {
            prototypeShallowCopy = (PrototypeShallowCopy) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototypeShallowCopy;
    }

    public PrototypeShallowCopy() {
    }

    public PrototypeShallowCopy(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PrototypeShallowCopy{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}