package mapper.ruanxinxin.mvc01.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("其他线程全部执行完毕啦");
            }
        });

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(2000L);

                    System.out.println(Thread.currentThread().getName() + "休眠了2秒");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() +"等待之后了。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println("主线程执行完毕！");

    }
}