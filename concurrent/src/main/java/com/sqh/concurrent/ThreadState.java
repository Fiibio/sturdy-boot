package com.sqh.concurrent;
/**
 * 线程状态
 * New：新创建的线程，尚未执行；
 * Runnable：运行中的线程，正在执行run()方法的Java代码；
 * Blocked：运行中的线程，因为某些操作被阻塞而挂起；
 * Waiting：运行中的线程，因为某些操作在等待中；
 * Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
 * Terminated：线程已终止，因为run()方法执行完毕。
 * */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start");
        Thread thread = new Thread(()->{
            System.out.println("new Thread--"+Thread.currentThread().getName());
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        //如果要等待thread执行完成，可以使用join()
        //thread.join(); //当前执行的线程(main)让出CPU,(thread)进入执行
        //可以传入参数，设置超时时间
        thread.join(20);
        System.out.println("main End");

    }
}
