package dbTest.multi_thread_in_action;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleObject2 {

    private static class SingleInnerObject {
        static SingleObject2 singleObject2 = new SingleObject2();
    }

    public static SingleObject2 getInstance() {
        return SingleInnerObject.singleObject2;
    }

    public static void main(String[] args) {
        int threadCount = 20;
        Integer s=new Integer(9);
        Integer t=9;
        System.out.println(s==t);
        final class Test {

        }
        ExecutorService service = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i ++) {
            service.execute(new MyRunnable());
        }
        service.shutdown();
    }
}

class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " : " + SingleObject2.getInstance().hashCode());
    }
}
