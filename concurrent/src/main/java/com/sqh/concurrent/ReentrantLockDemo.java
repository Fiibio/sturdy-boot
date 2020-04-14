package com.sqh.concurrent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现一个容器 提供add size方法
 * 写两个线程 线程1添加10个元素到容器中，线程2监控容器中元素个数
 * 当个数到5个时，线程2给出提示并结束
 * <p>
 * ReentrantLock
 * Condition提供的await()、signal()、signalAll()原理和synchronized锁对象的wait()、notify()、notifyAll()是一致的，并且其行为也是一样的
 * 同样的 await() 释放锁 后续尝试获得锁再执行、signal()通知但不释放锁
 *
 * 但是这里线程1 等待后 线程2执行完成通知，但线程1未继续执行
 */
public class ReentrantLockDemo {

    volatile ArrayList arrayList = new ArrayList();

    void add(Object o) {
        arrayList.add(o);
    }

    int size() {
        return arrayList.size();
    }

    public static void main(String[] args) {

        ReentrantLockDemo demo = new ReentrantLockDemo();

        ReentrantLock rl = new ReentrantLock();
        Condition condition = rl.newCondition();
        //线程2
        new Thread(()->{
            rl.lock();
            if(demo.size() != 5) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 2-- end");
                condition.signal();
            }

        }).start();

        //线程1
        new Thread(()->{
            rl.lock();
            for (int i = 0; i <10 ; i++) {
                demo.add(new Object());
                System.out.println("Thread 1-- "+i);
                if(demo.size() ==5){
                    condition.signal();
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            rl.unlock();

        }).start();
    }

}
