package com.sqh.concurrent;

import java.util.concurrent.*;

/**
 * @author
 * @date 2020/4/14 16:40
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        //FixedThreadPool 固定大小线程池
        //ExecutorService executor = Executors.newFixedThreadPool(3);
        //CachedThreadPool() 根据任务数量动态调整线程池的大小,可使用ThreadPoolExecutor指定范围，但并发超出后报错
        //ExecutorService executor = new ThreadPoolExecutor(1,6,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        //SingleThreadExecutor 单线程执行
        //ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i <5 ; i++) {
            executor.submit(new task(" "+i));
        }
        executor.shutdown();
    }

    static class task implements Runnable {
        public String name;
        public task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Thread "+name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
