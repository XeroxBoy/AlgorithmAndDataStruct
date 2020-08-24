package LeetCode.Medium.Array;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> topKMap = new TreeMap<>();
        for (int num : nums) {
            if (!topKMap.containsKey(num))
                topKMap.put(num, 0);
            else {
                topKMap.put(num, topKMap.get(num) + 1);
            }
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(topKMap::get));
        for (Integer key : topKMap.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (topKMap.get(key) > topKMap.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.remove());
        }
        Integer[] array = new Integer[res.size()];
        res.toArray(array);
        return Arrays.stream(array).mapToInt(x -> x).toArray();
    }
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(topKMap.entrySet());
//        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
//        return Arrays.stream(list.subList(0, k).stream().map(Map.Entry::getKey).toArray()).mapToInt(x -> (int) x).toArray();
//    }

}
