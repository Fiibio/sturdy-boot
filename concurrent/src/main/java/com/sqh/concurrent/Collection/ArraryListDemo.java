package com.sqh.concurrent.Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JingChen
 * @date 2020/6/4 16:07
 *
 *  List集合 特点有序，可重复
 *  底层用数组实现时，往指定位置插入元素时，其他元素需要移动
 *  底层用链表实现时，往指定位置插入元素时，其他元素不需要移动
 *  ArrayList默认初始大小10，当新插入元素但空间已满，需要扩容，扩容公式为 oldCapacity+oldCapacity>>1
 *  即扩容为原来的1.5倍
 */
public class ArraryListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList();

        list.add(0,"APPLE");
        list.add(1,"222");
        list.add(2,"q1wer");
        list.add(2,"APPLE");

        System.out.println(list.toString());

        List<String> linkedlist = new LinkedList<String>();
        linkedlist.add("1q");
        linkedlist.add("2w");
        linkedlist.add("3e");
        linkedlist.add(1,"2w");

        System.out.println(linkedlist.toString());



    }
}
