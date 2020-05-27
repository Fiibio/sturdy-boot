package com.sqh.concurrent.JVMTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JingChen
 * @date 2020/5/27 11:13
 *
 * 内存溢出
 * 设置JVM 参数 -Xms20m -Xmx20m  最大最小堆内存大小都是20M
 * 一次分配5M还可以接受，但是并发上来之后 就溢出了
 */
public class HeapOomError {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        int i = 0;
        while(true){
            list.add(new byte[5*1024*1024]);
            System.out.println("count = "+(++i));
        }
    }
}
