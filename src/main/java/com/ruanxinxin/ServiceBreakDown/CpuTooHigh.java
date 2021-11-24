package com.ruanxinxin.ServiceBreakDown;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CpuTooHigh {


    public static void main(String[] args) {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                10,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100),
                new ThreadFactoryBuilder().setNameFormat("XINXIN-TEST").build(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        executor.execute(() -> {
            int a = 1;
            while (true) {
                a++;
                a--;
            }
        });


    }


}
