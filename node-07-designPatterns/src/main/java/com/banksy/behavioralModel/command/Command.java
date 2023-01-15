package com.banksy.behavioralModel.command;

/**
 * 命令模式
 * Encapsulate a request as an object,thereby letting you parameterize clients with different requests,
 * queue or log requests,and support undoable operations.
 * 将一个请求封装成一个对象， 从而让你使用不同的请求把客户端参数化， 对请求排队或者记录请求日志， 可以提供命令的撤销和恢复功能。
 *
 * 请求方和执行方分开，扩展性得到的保障
 *
 * 角色：接收者角色【干活的角色， 命令传递到这里是应该被执行的】；
 *      命令角色【需要执行的所有命令都在这里声明】；
 *      调用者角色【接收到命令， 并执行命令】；
 * 优点：类间解耦；可扩展性；命令模式结合其他模式会更优秀；
 * 缺点：看Command的子类：如果有N个命令，问题就出来了，Command的子类就可不是几个，而是N个，
 *      这个类膨胀得非常大，这个就需要读者在项目中慎重考虑使用；
 * 适用场景：只要认为是命令的地方就可以采用命令模式， 例如， 在GUI开发中， 一个按钮的点击是一个命令， 可以采用命令模式；
 *         模拟DOS命令的时候， 当然也要采用命令模式；
 *         触发－反馈机制的处理等
 *
 * @author banksy
 * @version 1.0
 **/
class CommandClient {}

//请求者
class Invoker {
    private Command command;
    //接受命令
    public void setCommand(Command command) {
        this.command = command;
    }
    //执行命令
    public void action() {

    }
}

//抽象命令
public abstract class Command {
    //定义一个子类的全局共享变量
    protected final Receiver receiver;
    //实现类必须定义一个 接收者
    public Command(Receiver receiver) {
        this.receiver = receiver;
    }
    //每个命令都必须有一个执行命令的方法
    public abstract void excute();
}
class RequirementComment extends Command {
    public RequirementComment() {
        super(new RequirementGroup());
    }

    public RequirementComment(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void excute() {
        super.receiver.add();
    }
}
class PageCommend extends Command {
    public PageCommend() {
        super(new PageGroup());
    }

    public PageCommend(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void excute() {
        super.receiver.add();
    }
}
class CodeCommend extends Command {
    public CodeCommend() {
        super(new CodeGroup());
    }

    public CodeCommend(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void excute() {
        super.receiver.add();
    }
}

//接收者
abstract class Receiver {
    //定义接收者必须完成的业务
    abstract void find();
    abstract void add();
    abstract void delete();
    abstract void change();
    abstract void plan();
}

class RequirementGroup extends Receiver {
    @Override
    void find() {
        System.out.println("找到需求组......");
    }

    @Override
    void add() {
        System.out.println("增加一个需求......");
    }

    @Override
    void delete() {
        System.out.println("删除一个需求......");
    }

    @Override
    void change() {
        System.out.println("修改一个需求......");
    }

    @Override
    void plan() {
        System.out.println("更改需求计划......");
    }
}

class PageGroup extends Receiver {
    @Override
    void find() {
        System.out.println("找到UI组......");
    }

    @Override
    void add() {
        System.out.println("增加一个页面......");
    }

    @Override
    void delete() {
        System.out.println("删除一个页面......");
    }

    @Override
    void change() {
        System.out.println("修改一个页面......");
    }

    @Override
    void plan() {
        System.out.println("更改需求计划......");
    }
}

class CodeGroup extends Receiver {
    @Override
    void find() {
        System.out.println("找到代码组......");
    }

    @Override
    void add() {
        System.out.println("增加一个需求......");
    }

    @Override
    void delete() {
        System.out.println("删除一个需求......");
    }

    @Override
    void change() {
        System.out.println("修改一个需求......");
    }

    @Override
    void plan() {
        System.out.println("更改需求计划......");
    }
}