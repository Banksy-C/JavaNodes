package com.banksy.MultiThread.Syn_Thread_Runnable;

import org.junit.Test;

/**
 * 创建多线程的方式，方式一.1：继承于Thread类
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
 * 3. 创建Thread类的子类的对象
 * 4. 通过此对象调用start()
 *
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 * @Author banksy
 * @Data 2022/9/17 11:20 PM
 * @Version 1.0
 **/
//1. 创建一个继承于Thread类的子类
class WindowThread extends Thread {
    private static int ticket = 100;
    //2. 重写Thread类的run()
    @Override
    public void run() {
        while (true){
            if (ticket > 0) {
                //sleep10毫秒，可看出安全问题
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(getName() + "票号为：" + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}

public class SynThread {
    @Test
    public static void main(String[] args) {
        //3. 创建Thread类的子类的对象
        WindowThread t1 = new WindowThread();
        WindowThread t2 = new WindowThread();
        WindowThread t3 = new WindowThread();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}