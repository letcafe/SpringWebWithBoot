package dbTest.multi_thread_in_action.net;

public class Main{

    synchronized void myNotify() {
        notify();
    }

    public static void main(String[] args) throws InterruptedException {

        String s1 = new String("" + 1);
        String s2 = new String("" + 2);
        String s3 = new String("" + 3);
    }

}
