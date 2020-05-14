package dataStructure;

import java.util.LinkedHashMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CylicBarrier {

    public static void main(String[] args) {
        CylicBarrier demo = new CylicBarrier();
        demo.showInfThreadWhenDirectly();
    }

    private void process(CyclicBarrier cyclicBarrier) {
        final int n = 2;
        Runnable worker = () -> {
            for (int i = 0; i < n; i++) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                try {
                    int arrival_index = cyclicBarrier.await();
                    if (0 == arrival_index) {
                        System.out.println("first arrival Thread in this iteration is: "
                                + Thread.currentThread().getId());
                    }
                } catch (BrokenBarrierException | InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Worker is done");
            System.out.println("Thread of Worker is " + Thread.currentThread().getId());
        };

        Thread t1 = new Thread(worker);
        Thread t2 = new Thread(worker);
        t1.start();
        t2.start();
    }


    public void showInfThreadWhenDirectly() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () ->
                System.out.println("[Directly] Thread in invert call function is"
                        + Thread.currentThread().getId()));
        process(cyclicBarrier);
        System.out.println("[Directly] main Thread is " + Thread.currentThread().getId());
    }


}
