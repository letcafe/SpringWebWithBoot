package dbTest.multi_thread_in_action;


public class ThreadPoolTest implements Runnable {

    private volatile static boolean on = false;
    public static void main(String[] args) throws InterruptedException {
        Thread testThread = new Thread(new ThreadPoolTest(),"InterruptionInJava");
        //start thread
        testThread.start();
        Thread.sleep(1000);
        ThreadPoolTest.on = true;
        testThread.interrupt();

        System.out.println("main end");

    }

    @Override
    public void run() {
        while(!on){
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                System.out.println("caught exception right now: "+e);
            }
        }
    }

}
