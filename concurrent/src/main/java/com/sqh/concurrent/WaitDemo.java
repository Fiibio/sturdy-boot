package com.sqh.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author JingChen
 * @date 2020/4/30 10:56
 *
 *
 * 创建线程的方法
 * extend Thread类
 * 实现接口 implements Runnable
 *
 *
 */
public class WaitDemo {

    public synchronized void test1(){
            try {
                System.out.println("Thread start "+Thread.currentThread().getName());
                wait(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Thread End "+Thread.currentThread().getName());

    }

    public static void main(String[] args) {
        final WaitDemo waitDemo = new WaitDemo();
        System.out.println("mian start ----");
        for (int i = 0; i < 5 ; i++) {
            new Thread(()->{
                waitDemo.test1();
            }).start();
        }


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (waitDemo){
            waitDemo.notify();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------");
        synchronized (waitDemo){
            waitDemo.notifyAll();
        }

        System.out.println("mian end---");
    }
}
