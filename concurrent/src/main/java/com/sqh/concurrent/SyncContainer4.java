package com.sqh.concurrent;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * 实现一个容器 提供add size方法
 * 写两个线程 线程1添加10个元素到容器中，线程2监控容器中元素个数
 * 当个数到5个时，线程2给出提示并结束
 * <p>
 * latch 门闩
 */
public class SyncContainer4 {
    volatile ArrayList arrayList = new ArrayList();

    void add(Object o) {
        arrayList.add(o);
    }

    int size() {
        return arrayList.size();
    }


    public static void main(String[] args) throws InterruptedException {
        SyncContainer4 sc = new SyncContainer4();

        CountDownLatch latch = new CountDownLatch(1);

        //先线程2
        new Thread(() -> {
            //同步
            if (sc.size() != 5) {
                try {
                    latch.await();//准备
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 2 结束");
            }
        }).start();

        //线程1
        new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                sc.add(new Object());
                if (sc.size() == 5) {
                    latch.countDown();
                }
                System.out.println("thread 1 count" + i);
            }
        }).start();


        System.out.println("---------");
    }
}
