package com.sqh.concurrent;

import java.util.ArrayList;

/**
 * 实现一个容器 提供add size方法
 * 写两个线程 线程1添加10个元素到容器中，线程2监控容器中元素个数
 * 当个数到5个时，线程2给出提示并结束
 */
public class SyncContainer {
    volatile ArrayList arrayList = new ArrayList();

    void add(Object o) {
        arrayList.add(o);
    }

    int size() {
        return arrayList.size();
    }

    public void test1() {
        Object o1 = "o";
        for (int i = 0; i < 10; i++) {
            add(o1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncContainer sc = new SyncContainer();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sc.add(new Object());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 1----" + sc.size());
            }
        }).start();

        new Thread(() -> {
            while (true) {
//                System.out.println("----thread 2 " + sc.size());
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                if (sc.size() == 5) {
                    System.out.println("55555");
                    break;
                }

            }

        }).start();

        System.out.println("---------");
    }
}
