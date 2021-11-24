package mapper.ruanxinxin.mvc01.concurrency;

public class MyThreadLocal {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadLocal<String> threadLocal = new ThreadLocal<>();
                    threadLocal.set(Thread.currentThread().getName());
                    String name = threadLocal.get();
                    System.out.println("treadlocal的值为：" + name);
                    threadLocal.set(name+"你好啊");
                    System.out.println(threadLocal.get());
                }
            }).start();
        }

    }

}
