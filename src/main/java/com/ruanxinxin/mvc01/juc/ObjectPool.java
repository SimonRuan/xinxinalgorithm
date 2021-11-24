package com.ruanxinxin.mvc01.juc;

import com.ruanxinxin.mvc01.bean.Employee;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;

public class ObjectPool<T, R> {

    final private List<T> pool;
    final private Semaphore semaphore;

    public ObjectPool(int size, T t) {
        pool = new Vector<>(size);
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        semaphore = new Semaphore(size);
    }

    public R getObj(Function<T, R> func) throws InterruptedException {
        T t = null;
        semaphore.acquire();
        try {
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            semaphore.release();
        }
    }

    public static void main(String[] args) throws Exception {
        Employee employee = new Employee(23, "三", "744@qq.com", "M");
        ObjectPool<Employee, String> objectPool = new ObjectPool<>(3, employee);
       String d= objectPool.getObj(employee1 -> employee.getEmail());
        System.out.println(d);
        ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    }

}
