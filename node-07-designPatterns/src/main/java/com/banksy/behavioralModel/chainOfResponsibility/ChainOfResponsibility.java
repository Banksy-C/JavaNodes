package com.banksy.behavioralModel.chainOfResponsibility;

/**
 * 责任链模式
 * Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request.
 * Chain the receiving objects and pass the request along the chain until an object handles it.
 * 使多个对象都有机会处理请求， 从而避免了请求的发送者和接受者之间的耦合关系。
 * 将这些对象连成一条链， 并沿着这条链传递该请求， 直到有对象处理它为止；
 *
 * 角色：抽象处理者【定义一个处理请求的接口，包含抽象处理方法和一个后继连接】；
 *      具体处理者【实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理请求则处理，否则将该请求转给它的后继者】；
 *      客户类角色【创建处理链，并向链头的具体处理者对象提交请求，它不关心处理细节和请求的传递过程】；
 * 优点：将请求和处理分开。 请求者可以不用知道是谁处理的，处理者可以不用知道请求的全貌，两者解耦，提高系统的灵活性；
 * 缺点：一是性能问题， 每个请求都是从链头遍历到链尾，链长的话非常影响；二是调试不很方便；
 *      一般会在handler的setNext方法中设置阈值，判断是否超过；
 * 适用场景：
 *
 * @author banksy
 * @version 1.0
 **/
public class ChainOfResponsibility {
    public static void main(String[] args) {
        LeaveRequest leaveRequest = new LeaveRequest("小明", "身体不适！", 5);

        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();

        generalManager.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        groupLeader.submit(leaveRequest);
    }
}

//客户类角色；请假，一天以下只需要组长同意，1～3天部门经历同意，3～7天总经理同意
class LeaveRequest {
    private String name;//姓名
    private String content;//请假内容
    private int num;//请假天数

    public LeaveRequest(String name, String content, int num) {
        this.name = name;
        this.content = content;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

//抽象处理者
abstract class Handler {
    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVEN = 7;

    private int numStart;
    private int numEnd;

    private Handler nextHandler;//上级领导，责任链传递，下一个责任是谁

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    //各级领导处理请假的方法
    protected abstract void HandleLeave(LeaveRequest leave);

    //提交请假条
    public final void submit(LeaveRequest leave) {
        //该领导进行审批
        this.HandleLeave(leave);
        if (this.nextHandler != null && leave.getNum() > this.numEnd) {
            this.nextHandler.submit(leave);
        }else {
            System.out.println("流程结束！");
        }
    }
}

//具体处理者
class GroupLeader extends Handler {
    public GroupLeader() {
        super(0, Handler.NUM_ONE);
    }

    @Override
    protected void HandleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getName() + "天" + leave.getContent());
        System.out.println("组长已审批，同意！");
    }
}
class Manager extends Handler {
    public Manager() {
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    protected void HandleLeave(LeaveRequest leave) {
//        System.out.println(leave.getName() + "请假" + leave.getName() + "天" + leave.getContent() + "");
        System.out.println("部门经理已审批，同意！");
    }
}
class GeneralManager extends Handler {
    public GeneralManager() {
        super(Handler.NUM_THREE, Handler.NUM_SEVEN);
    }

    @Override
    protected void HandleLeave(LeaveRequest leave) {
//        System.out.println(leave.getName() + "请假" + leave.getName() + "天" + leave.getContent() + "");
        System.out.println("总经理已审批，同意！");
    }
}