package com.banksy.multiThread.Syn_Thread_Runnable;

import org.junit.Test;

/**
 * 同步方法Thread
 * 使用同步方法处理继承Thread类的方式中的线程安全问题
 *
 * @Author banksy
 * @Data 2022/9/15 8:12 PM
 * @Version 1.0
 **/
class Window4  extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            show();
        }
    }
    public static synchronized void show(){
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "票号为：" + ticket);
            ticket--;
        }
    }

}

public class SynMethodThread{
    @Test
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}