package mapper.ruanxinxin.mvc01.concurrency;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.*;

interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}

class ExpensiveFunction implements Computable<String, BigInteger> {

    @Override
    public BigInteger compute(String arg) {
        return new BigInteger(arg);
    }
}

public class Memoizer3<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);

        if (f == null) {
            Callable<V> eval = () -> c.compute(arg);
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.putIfAbsent(arg, ft);
            ft.run();
        }
        try {
            return f.get();
        } catch (ExecutionException e) {

        }
        return null;
    }
}

