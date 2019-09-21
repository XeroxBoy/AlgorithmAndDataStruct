package LeetCode.Easy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Foo {
    private Semaphore first_two = new Semaphore(0);
    private Semaphore second_three = new Semaphore(0);
    private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch third = new CountDownLatch(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
//        first_two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
//        first_two.acquire();
        Thread.sleep(2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
//        second_three.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
//        second_three.acquire();
        Thread.sleep(4);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public void firstGreat(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.countDown();
    }

    public void secondGreat(Runnable printSecond) throws InterruptedException {

        second.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.countDown();
    }

    public void thirdGreat(Runnable printThird) throws InterruptedException {

        third.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
