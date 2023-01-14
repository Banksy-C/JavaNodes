package com.banksy.behavioralModel.memento;

/**
 * 黑箱备忘录
 * 备忘录角色对发起人对象提供一个接口，而为其他对象提供一个窄接口
 * @author banksy
 **/
class BlackMementoClient {
    public static void main(String[] args) {
        //发起人
        BlackMementoOriginator originator = new BlackMementoOriginator();
        originator.stateDisplay();//查看原始状态
        //备忘录管理员
        BlackMementoCaretaker caretaker = new BlackMementoCaretaker();

        System.out.println("===============发起备份===============");
        //创建一个备忘录，给管理员；备忘录中的状态是此时发起人的当前状态
        caretaker.setBlackMemento(originator.createBlackMemento());
        System.out.println("===============备份完成，修改发起人状态===============");
        originator.changeState();//改变状态，此时改变的是发起人角色中的状态
        originator.stateDisplay();//查看发起人状态
        System.out.println("===============还原备份===============");
        originator.restoreBlackMemento(caretaker.getBlackMemento());
        originator.stateDisplay();//再次查看发起人状态
    }
}

//备忘录角色，由发起人内部类实现
public interface BlackMemento {}

//发起人角色【创建、恢复】
class BlackMementoOriginator {
    private String state = "初始状态";

    public void getState(String state) {
        this.state = state;
    }
    public void setState(String state) {
        this.state = state;
    }

    //创建一个备忘录
    public BlackMemento createBlackMemento() {
        return new StateMemento(this.state);
    }
    //恢复备忘录
    public void restoreBlackMemento(BlackMemento blackMemento) {
        //向下转型
        StateMemento stateMemento = (StateMemento) blackMemento;
        this.setState(stateMemento.getState());
    }

    public void changeState() {
        this.state = "非初始状态";
    }
    public void stateDisplay() {
        System.out.println("状态：" + state);
    }
    //备忘录角色，内部类实现
    private class StateMemento implements BlackMemento {
        private String state;

        public StateMemento() {
        }
        public StateMemento(String state) {
            this.state = state;
        }
        public String getState() {
            return state;
        }
        public void setState(String state) {
            this.state = state;
        }
    }
}

//管理员角色【管理、保存和提供】
class BlackMementoCaretaker {
    private BlackMemento blackMemento;

    public BlackMemento getBlackMemento() {
        return blackMemento;
    }

    public void setBlackMemento(BlackMemento blackMemento) {
        this.blackMemento = blackMemento;
        //在这里白箱可获取到备忘录中的数据，而黑箱备忘录写在内部类并且私有，所以访问不到，更安全
    }
}