package jvm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AtomicTest {

    public static volatile int volatileInteger = 0;

    public synchronized static void increase() {
        volatileInteger++;
    }

    public static void main(String[] args) {
//        Thread[] threads = new Thread[20];
//
//        for (int i = 0; i < 20; i++) {
//            threads[i]=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i=0;i<10000;i++){
//                        increase();
//                    }
//                }
//            });
//            threads[i].start();
//        }
//        for(Thread thread : threads){
//            while (thread.isAlive()){
//
//            }
//        }
//        System.out.println(volatileInteger);

        OneValueCache cache = new OneValueCache();

        BigInteger bigInteger = cache.integer.add(new BigInteger("12"));
        cache.list.add("dd");
        System.out.println(cache.toString());


    }


}

class OneValueCache {
    public final BigInteger integer = new BigInteger("10");
    public final List<String> list = new ArrayList<>();
}
