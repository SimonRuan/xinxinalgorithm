package mapper.ruanxinxin.mvc01.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    final  static List<Integer> sum=new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(70000);

        for (int i = 0; i < 70000; i++) {
            int num = i;
            new Thread(new Runnable() {
                @Override
                public void run() {


                        int time = 4;
                                //new Random().nextInt(10);
                        sum.add(time);
                        Thread.yield();
                        sum.add(1);
                        //Thread.sleep(time * 1000);
                        //System.out.println("第 " + num + " 个选手跑了 " + time + " 秒");
                        countDownLatch.countDown();

                }
            }).start();
        }
        countDownLatch.await();

      //int avg=  sum.stream().reduce((result,next)->( result+=next)).get()/7;
        System.out.println(sum.size());
    }
}
