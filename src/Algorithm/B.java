package Algorithm;

public class B extends A implements Runnable {
    int b;

    @Override
    public void run() {
        synchronized (A.class) {
            while (true) {
                System.out.println("透你妈");
                System.out.println(Thread.currentThread());
            }
        }
    }
}
