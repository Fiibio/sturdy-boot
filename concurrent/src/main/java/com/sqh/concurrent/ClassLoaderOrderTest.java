package com.sqh.concurrent;

/**
 * @author JingChen
 * @date 2020/5/22 17:13
 */
public class ClassLoaderOrderTest {

    private static String test1;

    private String test2;

    public ClassLoaderOrderTest(String test2) {
        System.out.println("构造方法--有参");
        this.test2 = test2;
    }

    static{
        System.out.println("Static info");
    }

    public ClassLoaderOrderTest() {
        System.out.println("构造方法--无参");
    }
}

class B extends ClassLoaderOrderTest{
    public B() {
        System.out.println("构造方法--B1111");
    }

    public B(String test2) {
        super(test2);
        System.out.println("构造方法--B2222");
    }

    public static void main(String[] args) {
        B A = new B();
        B B = new B(new String("sda"));
    }
}