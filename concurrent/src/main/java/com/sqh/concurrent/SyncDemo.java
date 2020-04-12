package com.sqh.concurrent;

public class SyncDemo {

    static int count = 0;

    public synchronized void test1() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            count++;
        }
    }

    void test2() {
        for (int i = 0; i < 100; i++) {
            count--;
        }
    }

    public static void main(String[] args) throws Exception {
        SyncDemo demo = new SyncDemo();
        new Thread(demo::test1, "test1").start();
        new Thread(demo::test2, "test2").start();
        System.out.println("count="+count);
    }

}