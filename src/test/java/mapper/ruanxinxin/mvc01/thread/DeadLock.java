package mapper.ruanxinxin.mvc01.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLock {
    private static Object lockA = new Object();
    private static Object lockB = new Object();

    Runnable runA=new Runnable(){
        @Override
        public void run() {
            synchronized (lockA){
                System.out.println("enter A's lock A");
                sleep();
                synchronized (lockB){
                    System.out.println("enter A's lock B");
                }
            }
        }
    };
    Runnable runB=new Runnable(){
        @Override
        public void run() {
            synchronized (lockB){
                System.out.println("enter B's lock B");
                //sleep();
                synchronized (lockA){
                    System.out.println("enter B's lock A");
                }
            }
        }
    };

    private void sleep()  {
        try {
            Thread.sleep(100l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 @Test
    public void go(){
     ExecutorService executorService= Executors.newCachedThreadPool();
     executorService.execute(runA);
     executorService.execute(runB);

 }


}
