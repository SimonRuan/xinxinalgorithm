package mapper.ruanxinxin.mvc01.concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args)  {
        BoundedHashSet<Integer> set=new BoundedHashSet<>(2);
        try {
            System.out.println( set.add(1));
            System.out.println(set.add(2));
            System.out.println(set.add(3));
        } catch (InterruptedException e) {

            e.printStackTrace();
        }



    }
}


class BoundedHashSet<T> {

    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<>());
        this.sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded)
                sem.release();
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved)
            sem.release();
        return wasRemoved;
    }

}