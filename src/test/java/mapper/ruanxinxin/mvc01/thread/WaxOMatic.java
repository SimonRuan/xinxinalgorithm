package mapper.ruanxinxin.mvc01.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car {
    private boolean waxOn = false;
    String name;
    public synchronized void waxed() {
        waxOn = true;     //打蜡完毕，可以抛光了
        notifyAll();
    }

    public synchronized void buffed() {
        waxOn = false;    //抛光完毕，可以打蜡了
        notifyAll();
    }

    public synchronized void waitingForWaxing() throws InterruptedException {
        while (waxOn == false)
            wait();     //还没打好蜡
    }

    public synchronized void waitingForBuffing() throws InterruptedException {
        while (waxOn == true)
            wait();     //还没抛好光
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car c) {
        car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(" 开始打蜡 !");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitingForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt ");
        }
        System.out.println(" 打好蜡了！ ");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car c) {
        car = c;

    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {

                System.out.println(" 开始抛光! ");
                TimeUnit.MILLISECONDS.sleep(200);
                  car.buffed();
                car.waitingForWaxing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt ");
        }
        System.out.println(" 抛好光了！");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }

}
