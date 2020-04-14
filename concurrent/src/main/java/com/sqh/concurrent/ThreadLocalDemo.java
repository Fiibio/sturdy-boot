package com.sqh.concurrent;

/**
 * 在一个线程中，横跨若干方法调用，需要传递的对象，我们通常称之为上下文（Context），它是一种状态，可以是用户身份、任务信息等
 *
 * ThreadLocal 可以
 */
public class ThreadLocalDemo {
    //伪代码 ThreadLocal使用
//    private Object User;
//    static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();
//    void user(){
//        try{
//        userThreadLocal.set(User);
//        step1();
//        step2();}
//        finally {
//            userThreadLocal.remove();
//        }
//
//    }
}
