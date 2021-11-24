package com.ruanxinxin.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class JoinTest {

    private static final int COUNT = 100000;
    private static AtomicInteger total = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(2);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                total.getAndIncrement();
            }
            latch.countDown();
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                total.getAndIncrement();
            }
            latch.countDown();
        });


        thread1.start();
        thread2.start();

        latch.await();

        System.out.println(total);



    }


}
