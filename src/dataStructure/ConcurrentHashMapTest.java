package dataStructure;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentHashMapTest {
    private static final long iterationTimes = 10000000;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Map<String, String> map = new HashMap<>();
//        ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        final Map<String, String> finalMap1 = map;

        for (int i = 0; i < iterationTimes; i++) {
            threadPool.execute(() -> finalMap1.put(UUID.randomUUID().toString(), ""));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("HashMap写入用时:" + ((endTime - startTime) / 1000.0) + "s");
        startTime = System.currentTimeMillis();
        map = new Hashtable<>();
        final Map<String, String> finalMap = map;
        for (int i = 0; i < 1000000; i++) {
            threadPool.execute(() -> finalMap.put(UUID.randomUUID().toString(), ""));
        }
        endTime = System.currentTimeMillis();
        System.out.println("HashTable写入用时:" + ((endTime - startTime) / 1000.0) + "s");
        startTime = System.currentTimeMillis();
        map = new HashMap<>();
        final Map<String, String> finalMap2 = map;

        for (int i = 0; i < iterationTimes; i++) {
            synchronized (finalMap) {
                threadPool.execute(() -> finalMap2.put(UUID.randomUUID().toString(), ""));
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Synchronized写入用时:" + ((endTime - startTime) / 1000.0) + "s");
        startTime = System.currentTimeMillis();
        map = new ConcurrentHashMap<>();
        Map<String, String> finalMap3 = map;
        for (int i = 0; i < iterationTimes; i++) {
            threadPool.execute(() -> finalMap3.put(UUID.randomUUID().toString(), ""));
        }
        endTime = System.currentTimeMillis();
        System.out.println("ConcurrentHashMap写入用时:" + ((endTime - startTime) / 1000.0) + "s");


//
//        Lock lock = new ReentrantLock();
//        Map<Integer,String> map = new HashMap<>();
//        long startTime = 0;
//        long endTime = 0;
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < iterationTimes; i++) {
//            map.put(i, "");
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("HashMap写入用时:"+((endTime-startTime)/1000.0) + "s");
//        map = new Hashtable<>();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < iterationTimes; i++) {
//                    map.put(i, "");
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("HashTable写入用时:"+((endTime-startTime)/1000.0) + "s");
//        map = new HashMap<>();
//        startTime = System.currentTimeMillis();
//            for (int i = 0; i < iterationTimes; i++) {
//                synchronized(map) {
//                    map.put(i, "");
//            }
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("Synchronized写入用时:"+((endTime-startTime)/1000.0) + "s");
//        map = new HashMap<>();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < iterationTimes; i++) {
//            try{
//                lock.lock();
//                map.put(i, "");}
//            finally {
//                lock.unlock();
//            }
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("lock写入用时:"+((endTime-startTime)/1000.0) + "s");
//        map = new ConcurrentHashMap<>();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < iterationTimes; i++) {
//                    map.put(i, "");
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("ConcurrentHashMap写入用时:"+((endTime-startTime)/1000.0) + "s");
    }
}
