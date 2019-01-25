package dbTest.multi_thread_in_action;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleObject {
    private volatile static SingleObject singleObject;

    private SingleObject() {

    }

    public static SingleObject getInstance() {
        if (singleObject == null) {
            synchronized (SingleObject.class) {
                if (singleObject == null) {
                    doSomethingInit(100);
                    singleObject = new SingleObject();
                }
            }
        }
        return singleObject;
    }

    private static void doSomethingInit(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int threadCount = 20;
        ExecutorService service = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i ++) {
            service.execute(new MyRunnable());
        }
        service.shutdown();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " : " + SingleObject.getInstance().hashCode());
    }
}
