package mapper.ruanxinxin.mvc01.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSyncTest {
    public static void main(String[] args) throws InterruptedException {

        ListHelper listHelper = new ListHelper();
        Runnable run = () -> {

            try {
                listHelper.putIfAbsent();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        new Thread(run).start();

        listHelper.putIfAbsent();

        Thread.sleep(2000l);
        System.out.println(listHelper.list);
    }


}

class ListHelper {
    public List list = Collections.synchronizedList(new ArrayList<String>());

    public synchronized void putIfAbsent() throws InterruptedException {
        for (int i = 0; i < 10; i++) {

            list.add(Thread.currentThread().getName() + i);
            Thread.sleep(10L);
            Thread.yield();
        }

    }

}