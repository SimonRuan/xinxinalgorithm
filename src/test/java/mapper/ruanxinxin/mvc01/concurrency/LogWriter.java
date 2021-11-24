package mapper.ruanxinxin.mvc01.concurrency;

import org.junit.runner.notification.RunListener;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LogWriter {
    private final BlockingQueue<String> queue;
    private final LoggerThread logger;

    static int i = 23;
    static {
        i = 199;
        System.out.println(i);
    }



    public LogWriter(PrintWriter writer) {
        this.queue = new LinkedBlockingQueue<>(10000);
        this.logger = new LoggerThread(writer);
    }

    public void start() {
        logger.start();
    }

    public void log(String msg) throws InterruptedException {
        queue.put(msg);
        Runtime.getRuntime().addShutdownHook(new Thread());
    }

    private class LoggerThread extends Thread {
        private final PrintWriter writer;

        public LoggerThread(PrintWriter writer) {
            this.writer = writer;
        }

        public void run() {
            try {
                while (true)
                    writer.print(queue.take());
            } catch (InterruptedException ignored) {
            } finally {
                writer.close();
            }
        }
    }

    public static void main(String[] args) {

    }
}


