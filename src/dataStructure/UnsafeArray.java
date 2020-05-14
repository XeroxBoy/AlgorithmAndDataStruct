package dataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UnsafeArray {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new CopyOnWriteArrayList<>();
        new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                list.add(i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                list.add(i);
            }
        }).start();
        Thread.sleep(5000);
        System.out.println(list);
    }
}
