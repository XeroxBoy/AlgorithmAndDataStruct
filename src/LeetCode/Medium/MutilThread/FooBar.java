package LeetCode.Medium.MutilThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(1);
    private int n;
    private CountDownLatch latch0 = new CountDownLatch(1);
    private CountDownLatch latch1 = new CountDownLatch(1);
    private volatile boolean finish = false;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public FooBar(int n) {
        this.n = n;

    }

    public void foo1(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            latch1.countDown();
            latch0.await();
            latch0 = new CountDownLatch(1);
        }
    }

    public void bar1(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            latch1.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            latch1 = new CountDownLatch(1);
            latch0.countDown();
        }
    }


    public void foo2(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (finish) {
                Thread.yield();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            finish = true;
        }
    }

    public void bar2(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!finish) {
                Thread.yield();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            finish = false;
        }
    }

    public void foo3(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if (finish)
                condition.await();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            finish = true;
            condition.signalAll();
            lock.unlock();
        }
    }

    public void bar3(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (!finish)
                condition.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            finish = false;
            condition.signalAll();
            lock.unlock();
        }
    }

    public void foo4(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s2.acquire();
            printFoo.run();
            s1.release();
        }
    }

    public void bar4(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s1.acquire();
            printBar.run();
            s2.release();
        }
    }

}