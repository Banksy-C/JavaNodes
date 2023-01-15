package com.banksy.behavioralModel.memento;

/**
 *
 * Without violating encapsulation,capture and externalize an object's internal state
 * so that the object can be restored to this state later.
 * 在不破坏封装性的前提下， 捕获一个对象的内部状态， 并在该对象之外保存这个状态。 这样以后就可将该对象恢复到原先保存的状态。
 * 通俗地说，备忘录模式就是一个对象的备份模式， 提供了一种程序数据的备份方法
 *
 * 角色：发起人【记录当前时刻的内部状态， 负责定义哪些属于备份范围的状态， 负责创建和恢复备忘录数据】；
 *      备忘录角色【负责存储Originator发起人对象的内部状态， 在需要的时候提供发起人需要的内部状态】：
 *      备忘录管理员角色【对备忘录进行管理、 保存和提供备忘录】；
 * 优点：提供一种可恢复状态的机制。当用户需要时比较方便地将数据恢复到某个历史的状态；
 *      实现了内部状态的封装。除了创建它的发起人之外，其他对象都不能够访问这些状态信息；
 *      简化了发起人，发起人不需要管理和保存其内部状态的各个备份，所有状态信息都保存在备忘录中，并由管理者进行管理，这符合单一职责原则；
 * 缺点：资源消费大，若要保存内部状态信息过多或特别频繁，将会占用比较大的内存资源；
 * 适用场景：需要保存和恢复数据的相关状态场景；提供一个可回滚（rollback） 的操作；
 *
 * 两个等效接口：窄接口【只允许把备忘录对象传给其他对象】和 宽接口【允许读取所有数据】
 *
 * 白箱备忘录模式：对任何对象都提供一个接口，即宽接口。备忘录角色的内部所存储的状态对所有对象公开；
 *
 * @author banksy
 * @version 1.0
 **/
class WriteMementoClient {
    public static void main(String[] args) {
        //发起人
        WriteMementoOriginator originator = new WriteMementoOriginator();
        originator.stateDisplay();//查看原始状态
        //备忘录管理员
        WriteMementoCaretaker caretaker = new WriteMementoCaretaker();

        System.out.println("===============发起备份===============");
        //创建一个备忘录，给管理员；备忘录中的状态是此时发起人的当前状态
        caretaker.setWriteMemento(originator.createWriteMemento());
        System.out.println("===============备份完成，修改发起人状态===============");
        originator.changeState();//改变状态，此时改变的是发起人角色中的状态
        originator.stateDisplay();//查看发起人状态
        System.out.println("===============还原备份===============");
        originator.restoreWriteMemento(caretaker.getWriteMemento());
        originator.stateDisplay();//再次查看发起人状态
    }
}


//发起人角色【创建、恢复】
class WriteMementoOriginator {
    private String state = "初始状态";

    public void getState(String state) {
        this.state = state;
    }
    public void setState(String state) {
        this.state = state;
    }
    //创建一个备忘录
    public WriteMemento createWriteMemento() {
        return new WriteMemento(this.state);
    }
    //恢复备忘录
    public void restoreWriteMemento(WriteMemento writeMemento) {
        this.setState(writeMemento.getState());
    }

    public void changeState() {
        this.state = "非初始状态";
    }
    public void stateDisplay() {
        System.out.println("状态：" + state);
    }

}

//备忘录角色
public class WriteMemento {
    private String state;

    public WriteMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

//管理员角色【管理、保存和提供】
class WriteMementoCaretaker {
    private WriteMemento writeMemento;

    public WriteMemento getWriteMemento() {
        return writeMemento;
    }

    public void setWriteMemento(WriteMemento writeMemento) {
        this.writeMemento = writeMemento;
    }
}