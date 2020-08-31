package Algorithm;

public class A implements Runnable {
    int a;

    @Override
    public void run() {
        synchronized (A.class) {
            while (true) {
                System.out.println(Thread.currentThread());
            }
        }
    }
}
