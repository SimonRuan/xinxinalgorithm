package mapper.ruanxinxin.mvc01.concurrency;

import org.junit.Test;
import org.junit.runner.notification.RunListener;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

@RunListener.ThreadSafe
public class PrimeGenerator implements Runnable {

    private final List<BigInteger> primes = new ArrayList<>();
    private  boolean cancelled;//todo 试一下不带volatile会怎样

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
             p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    @Test
    public void test() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();

        while (!generator.get().contains(new BigInteger("17"))) {

        }
        generator.cancel();

        System.out.println(generator.get());
    }
}

