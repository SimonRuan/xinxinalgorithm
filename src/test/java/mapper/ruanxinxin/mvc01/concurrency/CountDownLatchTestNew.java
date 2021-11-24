package mapper.ruanxinxin.mvc01.concurrency;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchTestNew {

    private static AtomicInteger count=new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {


        CountDownLatch latch = new CountDownLatch(1000);

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" +count.getAndIncrement()+ "已经启动。。。");

                latch.countDown();


            }).start();
        }
        latch.await();

        System.err.println(count.get()+"**************");

    }


}
