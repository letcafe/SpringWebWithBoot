package dbTest.multi_thread_in_action;


import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadDemo1 implements Runnable, Thread.UncaughtExceptionHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new ThreadDemo1());
        System.out.println(1);
        throw new RuntimeException();

    }

    private static void doSomething() {
    }

    static int tryFinallyTest() {
        int i = 0;
        try {
            return i;
        } finally {
            i = 1;
            System.out.println("finally executed");
        }
    }

    boolean flag = true;
    volatile int i = 0;

    @Override
    public void run() {
        System.out.println("thread运行状态:" + flag);
        while (flag) {

            i++;
        }
        System.out.println("输出结果:  i= " + i);
    }

    public void cancel() {
        flag = false;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("hahaha");
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.SEVERE, "Thread terminated with exception : " + t.getName(), e);
    }
}