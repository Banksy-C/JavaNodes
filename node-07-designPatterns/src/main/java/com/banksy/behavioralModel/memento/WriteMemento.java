package com.banksy.behavioralModel.memento;

/**
 * @author banksy
 * @version 1.0
 * @Date 2023/1/10 9:39 PM
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