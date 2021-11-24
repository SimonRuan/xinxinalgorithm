package mapper.ruanxinxin.mvc01.employee;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested){
                    i++;
                    System.err.println(i);
                }

            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(5);
        stopRequested = true;
    }
}
