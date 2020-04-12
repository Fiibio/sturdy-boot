package com.sqh.concurrent;

import java.util.ArrayList;

/**
 * 实现一个容器 提供add size方法
 * 写两个线程 线程1添加10个元素到容器中，线程2监控容器中元素个数
 * 当个数到5个时，线程2给出提示并结束
 */
public class SyncContainer2 {
    volatile ArrayList arrayList = new ArrayList();

    void add(Object o) {
        arrayList.add(o);
    }

    int size() {
        return arrayList.size();
    }

    public static void main(String[] args) throws InterruptedException {
        SyncContainer2 sc = new SyncContainer2();
        Object o = new Object();

        //先线程2
        new Thread(() -> {
            //同步
            synchronized (o){
                if(sc.size() != 5){
                    try {
                        o.wait();//wait会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread 2 结束");
                }
            }
        }).start();

        //线程1
        new Thread(() -> {

            synchronized (o) {
                for (int i = 0; i < 10; i++) {
                    sc.add(new Object());
                    if(sc.size()==5){
                        o.notify();//但是notify不会释放锁，这样就导致线程2 只有等线程1 执行完才能拿到锁
                    }
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread 1 count"+ i);
                }
            }
        }).start();



        System.out.println("---------");
    }
}
