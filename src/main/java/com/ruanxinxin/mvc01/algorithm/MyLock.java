package com.ruanxinxin.mvc01.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {

    public static void main(String[] args) throws InterruptedException {
        MyQueue myQueue = new MyQueue();
        for(int i=0;i<1000;i++){
             int j=i;
            new Thread(() -> myQueue.take()).start();
            new Thread(() -> myQueue.put(String.valueOf(j))).start();
        }
        Thread.sleep(10000);
    }


}


class MyQueue {

    private List<String> list = new ArrayList<>();

    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public String take() {
        lock.lock();
        String str = null;
        try {
            while (list.size() == 0) {
                System.out.println("队列为空！");
                notEmpty.await();
            }
            str = list.get(0);
            System.out.println("取出来：" + str);
            list.remove(0);
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return str;
    }

    public void put(String str) {
        lock.lock();
        try {
            while (list.size() == 1) {
                notFull.await();
            }
            list.add(str);
            System.out.println("放进去"+str);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
