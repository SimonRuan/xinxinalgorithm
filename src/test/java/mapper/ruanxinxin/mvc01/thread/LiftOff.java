package mapper.ruanxinxin.mvc01.thread;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

//    public LiftOff(int countDown) {
//        this.countDown = countDown;
//    }

    public String status() {

        Thread.currentThread().setPriority(id*4);
        return "#" + id + " (" +
                (countDown > 0 ? countDown : "Liftoff!") + "). ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            try {
                Thread.sleep(0L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        int i = 5;
        while (i-- > 0) {
            executorService.execute(new LiftOff());

        }
        executorService.shutdown();
//        executorService.execute(new LiftOff());
//        new Thread(
//                () -> System.err.println("hahahahahaha")
//        ).start();

    }

    @Test
    public void test11() {
        int i = 0;

        for (; i < 10; ) {
            int j = i++;
            System.out.println("i = " + i + " , j = " + j);
        }
    }
}

