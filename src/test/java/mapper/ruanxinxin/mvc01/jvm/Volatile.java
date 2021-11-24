package mapper.ruanxinxin.mvc01.jvm;

import java.util.concurrent.*;

public class Volatile {
    private static volatile int i = 0;
   //private static CountDownLatch latch=new CountDownLatch(2);
    private static CyclicBarrier barrier=new CyclicBarrier(2);
    public static void setI(int value) throws InterruptedException {

        i = value;
        Thread.sleep(100l);
    }

    public static int getI() throws InterruptedException {
        //Thread.sleep(100l);
        return i;

    }

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        new Thread(() -> {
            try {
                Thread.sleep(100);
                barrier.await();
                setI(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(100);
                barrier.await();
                System.out.println(getI());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        //System.out.println("latch结束了");


    }
}
