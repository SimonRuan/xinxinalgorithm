package mapper.ruanxinxin.mvc01.thread;

import java.util.EventListener;
import java.util.concurrent.atomic.AtomicInteger;

public class FieldTest {
    private static volatile boolean asleep;
    private static volatile AtomicInteger number = new AtomicInteger(0);
    private static Runnable run1 = () -> {
        while (!asleep) {
            countSheep();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        new Thread(run1).start();
        while (number.get() < 500) {

        }
        asleep = true;

        System.out.println(number.get());
    }

    public static void countSheep() {
        number.getAndIncrement();
    }
}


