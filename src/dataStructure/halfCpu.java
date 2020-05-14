package dataStructure;

import java.util.Arrays;
import java.util.HashSet;

public class halfCpu {
    private final static int times = 100;
    private int currentEvenValue = 0;

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();
        halfCpu hc1 = new halfCpu();
        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                System.out.println(Thread.currentThread().getName() + " " + hc1.next());
            }
        }
        ).start()
        ;
        new Thread(() -> {
            for (int i = 0; i < times; i++) {
                System.out.println(Thread.currentThread().getName() + " " + hc1.next());
            }
        }
        ).start();
        long endTime = System.nanoTime();
        Thread.sleep(1000);
        System.out.println("耗时:" + (endTime - startTime));
        //        for (int i = 0; i < 10000000; i++) {
//            long start_time = System.currentTimeMillis();
//            while((System.currentTimeMillis()-start_time)<busyTime){}
//            System.out.println(i);
//            try {
//                Thread.sleep(idleTime);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public synchronized int next() {
        ++currentEvenValue;
//        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

}
