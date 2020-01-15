package LeetCode.Medium.MutilThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private volatile int now = 1;
    private Semaphore sZero = new Semaphore(1);
    private Semaphore sOne = new Semaphore(0);
    private Semaphore sTwo = new Semaphore(0);
    private ReentrantLock lock = new ReentrantLock();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeo = new ZeroEvenOdd(5);
        IntConsumer printNumber = System.out::print;
        new Thread(() -> {
            try {
                zeo.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeo.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeo.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            sZero.acquire();
            if (now > n) return;
            lock.lock();
            printNumber.accept(0);
            lock.unlock();
            if (now % 2 == 0) {
                sOne.release();
            } else if (now % 2 == 1) {
                sTwo.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            sOne.acquire();
            if (now > n) return;
            lock.lock();
            printNumber.accept(now++);
            lock.unlock();
            if (now <= n)
                sZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            sTwo.acquire();
            if (now > n) return;
            lock.lock();
            printNumber.accept(now++);
            lock.unlock();
            if (now <= n)
                sZero.release();
        }
    }
}
