package com.sqh.concurrent.JVMTest;

import java.util.HashMap;

/**
 * @author JingChen
 * @date 2020/5/27 17:28
 *
 * 内存泄漏导致的内存溢出
 * 内存泄漏指，一些对象已经不再被使用，但GC未正确识别回收
 * JVM参数为 -Xms10m -Xmx10m
 */
public class MemoryLeakOomError {

    static class Key {
        int id;
        public Key(int id) {
            this.id = id;
        }
        //只重写hashCode方法，不重写equals方法
        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }
    public static void main(String[] args) {

        HashMap map = new HashMap();

        while (true){
            for (int i = 0; i < 10000; i++) {
                Key k = new Key(i);
                if(!(map.containsKey(k))){
                    map.put(k,"num=" + i);
                    System.out.println("num is "+ i);
                }
            }
        }
    }
}
