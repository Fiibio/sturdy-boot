package com.sqh.concurrent.Collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JingChen
 * @date 2020/6/4 16:32
 *
 *  Arrays.asList
 *  list.toArray
 */
public class ArrayAndListConvert {

    public static void main(String[] args) {
        //1.先弄个array数组
        String[] s = new String[3];
        s[0]="one";
        s[1]="two";
        s[2]="three";

        //2.把数组转成list集合
        List<String> list = Arrays.asList(s);

        list.set(0,"zhangsan");
        System.out.println(list.toString());

        // 这种对list个数进行的操作会抛出异常 java.lang.UnsupportedOperationException
//        list.add("qwe1");
//        list.remove(1);
//        list.clear();

        System.out.println("--------------------");

        List<String> stringList = new ArrayList<String>();
        stringList.add("2");
        stringList.add("1");
        stringList.add("3");

        // 泛型丢失或者说类型擦除 无法使用String[]接受无参方法返回的结果
        //String[] strings =stringList.toArray();

        str = stringList.toArray();

    }
}
