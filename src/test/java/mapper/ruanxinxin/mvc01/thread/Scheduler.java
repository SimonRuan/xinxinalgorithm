package mapper.ruanxinxin.mvc01.thread;

import java.util.concurrent.*;

public class Scheduler {
   private static Runnable run1= () -> System.out.println("run1 start ...");

   private static Runnable run2= () -> System.out.println("run2 start ...");



    public static void main(String[] args) {
        ScheduledThreadPoolExecutor schedule=new ScheduledThreadPoolExecutor(4);
        schedule.scheduleAtFixedRate(run1,5,1,TimeUnit.SECONDS);
        schedule.scheduleAtFixedRate(run2,5,1,TimeUnit.SECONDS);

    }




}
