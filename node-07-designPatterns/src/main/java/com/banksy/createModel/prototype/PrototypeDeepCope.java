package com.banksy.createModel.prototype;

import java.util.Date;

/**
 * 深拷贝
 * @author banksy
 **/
public class PrototypeDeepCope implements Cloneable {
    private String name;
    private Date createTime;

    @Override
    protected PrototypeDeepCope clone() {
        PrototypeDeepCope prototypeDeepCope = null;
        try {
            prototypeDeepCope = (PrototypeDeepCope) super.clone();
            prototypeDeepCope.createTime = (Date) this.createTime.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototypeDeepCope;
    }

    public PrototypeDeepCope() {
    }

    public PrototypeDeepCope(String name, Date createTime) {
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
        return "PrototypeDeepCope{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }

}