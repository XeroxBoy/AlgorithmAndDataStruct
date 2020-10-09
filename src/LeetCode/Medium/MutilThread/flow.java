package LeetCode.Medium.MutilThread;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class flow {
    public static void out(int i) {
        System.out.println(i);
        out(++i);
    }

    public static void main(String[] args) {
        System.out.println("start");
        new Thread(() -> {
            out(1);
        }).start();
//        new Thread(() -> {
//            out(1);
//        }).start();
//        List<Object> list = new ArrayList<>();
//        new Thread(() -> {
//            while (true) {
//                list.add(new TreeNode(1));
//            }
//        }).start();
//        new Thread(() -> {
//            while (true) {
//                list.add(new TreeNode(2));
//            }
//        }).start();
//        new Thread(() -> {
//            while (true) {
//                list.add(new TreeNode(3));
//            }
//        }).start();
//        new Thread(() -> {
//            while (true) {
//                list.add(new TreeNode(4));
//            }
//        }).start();
//        new Thread(() -> {
//            while (true) {
//                list.add(new TreeNode(5));
//            }
//        }).start();
    }
}



