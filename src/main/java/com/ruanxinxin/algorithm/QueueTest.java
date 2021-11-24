package com.ruanxinxin.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());//取出并删除
        }
    }

}
