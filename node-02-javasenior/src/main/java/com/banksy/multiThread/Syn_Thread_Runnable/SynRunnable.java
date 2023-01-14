package com.banksy.multiThread.Syn_Thread_Runnable;

import org.junit.Test;

/**
 * 创建多线程的方式一.2：实现Runnable接口
 * 1. 创建一个实现了Runnable接口的类
 * 2. 实现类去实现Runnable中的抽象方法：run()
 * 3. 创建实现类的对象
 * 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5. 通过Thread类的对象调用start()
 *
 *
 * 比较创建线程的两种方式。
 * 开发中：优先选择：实现Runnable接口的方式
 * 原因：1. 实现的方式没有类的单继承性的局限性
 *      2. 实现的方式更适合来处理多个线程有共享数据的情况。
 *
 * 联系：public class Thread implements Runnable
 * 相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中。
 *
 * @Author banksy
 * @Data 2022/9/17 11:20 PM
 * @Version 1.0
 **/
//1. 创建一个实现了Runnable接口的类
class WindowsRunnable implements Runnable{
    private int ticket = 100;
    //2. 实现类去实现Runnable中的抽象方法：run()
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
                System.out.println(Thread.currentThread().getName() + "票号为：" + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}

public class SynRunnable {
    @Test
    public static void main(String[] args) {
        //3. 创建实现类的对象
        WindowsRunnable w = new WindowsRunnable();
        //4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        //5. 通过Thread类的对象调用start():① 启动线程 ②调用当前线程的run()-->调用了Runnable类型的target的run()
        t1.start();
        t2.start();
        t3.start();
    }
}