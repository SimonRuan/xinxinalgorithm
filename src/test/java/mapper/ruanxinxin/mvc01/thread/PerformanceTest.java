package mapper.ruanxinxin.mvc01.thread;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PerformanceTest {
    private  long var1;
    static long test(Incrementable incr) {
        long start = System.nanoTime();
        for (long i = 0; i < 10000000L; i++) {
            incr.increment();
        }
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        long synTime=test(new SynTest());
        long lockTime=test(new LockTest());
        System.out.printf("synchronized: %1$10d\n",synTime);
        System.out.printf("lock:         %1$10d\n",lockTime);
        System.out.println((double)lockTime/(double)synTime);


    }
}

abstract class Incrementable {
    protected long counter =0;

    public abstract void increment();
}

class SynTest extends Incrementable {

    @Override
    public synchronized void increment() {

        ++counter;
    }
}

class LockTest extends Incrementable {
    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        lock.lock();
        try {
            ++counter;

        } finally {
            lock.unlock();
        }
    }
}