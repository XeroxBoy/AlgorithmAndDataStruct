package LeetCode.Medium.MutilThread;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    private int num = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (num <= n) {
                if (!(num % 5 != 0 && num % 3 == 0)) wait();
                if (!(num % 5 != 0 && num % 3 == 0)) continue;
                if (num > n) break;

                printFizz.run();
                num++;
                notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (num <= n) {
                if (!(num % 3 != 0 && num % 5 == 0)) wait();
                if (!(num % 3 != 0 && num % 5 == 0)) continue;
                if (num > n) break;
                printBuzz.run();
                num++;
                notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (num <= n) {
                if (!(num % 3 == 0 && num % 5 == 0)) wait();
                if (!(num % 3 == 0 && num % 5 == 0)) continue;
                if (num > n) break;
                printFizzBuzz.run();
                num++;
                notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (num <= n) {
                if (num % 3 == 0 || num % 5 == 0) wait();
                if (num % 3 == 0 || num % 5 == 0) continue;
                if (num > n) break;
                printNumber.accept(num);
                num += 1;
                notifyAll();
            }
        }
    }
}

