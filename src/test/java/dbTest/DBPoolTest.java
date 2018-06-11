package dbTest;

import org.junit.Test;

public class DBPoolTest {


    @Test
    public void DBPoolTest() throws Exception {
        long runTime = DBWithPool();
        System.out.println("DB with Pool cost time = " + runTime);
    }

    private long DBWithPool() {
        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[8];
        for(int i = 0; i < threads.length; i ++) {
            threads[i] = new Thread(()->{
                System.out.println("Thread has been initialized");
            });
        }
        for(Thread thread : threads) {
            thread.run();
        }
        long costTime = System.currentTimeMillis() - startTime;
        return costTime;
    }
}
