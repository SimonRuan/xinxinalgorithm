package mapper.ruanxinxin.mvc01.concurrency;

import javassist.bytecode.stackmap.BasicBlock;

import java.util.concurrent.CountDownLatch;

public class TestHarness {
    public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {

                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
       long time= timeTasks(10, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" start.....");
            }
        });
        System.out.println(time);
    }
}
