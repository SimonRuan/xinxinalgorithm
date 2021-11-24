package mapper.ruanxinxin.mvc01.concurrency;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadDeadLock {

    ExecutorService exec= Executors.newSingleThreadExecutor();

    public class RenderPageTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            Future<String> header,footer;
            header=exec.submit(() -> {Thread.sleep(1000); return "header";});
            footer=exec.submit(() -> {Thread.sleep(1000); return"footer";});

            String page="page";
            return header.get()+page+footer.get();

        }
    }

    @Test
    public void test() throws Exception {

        ExecutorService executorService=Executors.newCachedThreadPool();
        List<String> list=new ArrayList<>();
        list.add("22");
        executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return list.get(0);
            }
        });
    }
}
