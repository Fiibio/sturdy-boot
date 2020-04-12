package com.sqh.concurrent;
/**
 * 线程启动
 * Java用Thread对象表示一个线程，通过调用start()启动一个新线程；
 * 一个线程对象只能调用一次start()方法；并在新线程中执行run()方法
 * 线程的执行代码写在run()方法中；
 * 线程调度由操作系统决定，程序本身无法决定调度顺序；
 * Thread.sleep()可以把当前线程暂停一段时间。
 *
 * */
public class ThreadStart {
    public static void main(String[] args) {
        System.out.println("main thread start--");

        System.out.println("main--"+Thread.currentThread().getName());
        Thread t = new Thread(){
            public void run() {
                System.out.println("subThread start");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("subThread--"+Thread.currentThread().getName());
                System.out.println("subThread end");
            }
        };
        t.start();
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("main end--");
    }

}
