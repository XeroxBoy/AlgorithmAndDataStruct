package LeetCode.Medium.OS;

import java.util.*;

class greatLRU {

    private int cap;
    private Map<Integer, Integer> map = new LinkedHashMap<>();  // 保持插入顺序

    public class LRUCache {
        private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 使用伪头部和伪尾部节点
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 如果 key 存在，先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                // 如果 key 不存在，创建一个新的节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                // 添加进哈希表
                cache.put(key, newNode);
                // 添加至双向链表的头部
                addToHead(newNode);
                ++size;
                if (size > capacity) {
                    // 如果超出容量，删除双向链表的尾部节点
                    DLinkedNode tail = removeTail();
                    // 删除哈希表中对应的项
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }
    }

    public greatLRU(int capacity) {
        this.cap = capacity;
    }

    public static void main(String[] args) {
        greatLRU cache = new greatLRU(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));     // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));      // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));      // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        cache.get(4);       // 返回  4
    }

    public int get(int key) {
        if (map.keySet().contains(key)) {
            int value = map.get(key);
            map.remove(key);
            // 保证每次查询后，都在末尾
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.keySet().contains(key)) {
            map.remove(key);
        } else if (map.size() == cap) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();

            // int firstKey = map.e***ySet().iterator().next().getValue();
            // map.remove(firstKey);
        }
        map.put(key, value);
    }
}

//class LRUCache {
//    private Map<Integer, Integer> lruMap;
//    private Queue<Integer> queue;
//    private int mapCapacity;
//
//    public LRUCache(int capacity) {
//        lruMap = new ConcurrentHashMap<>(capacity);
//        queue = new LinkedList<>();
//        mapCapacity = capacity;
//    }
//
//    public int get(int key) {
//        if (lruMap.containsKey(key)) {
//            queue.remove(key);
//            queue.offer(key);
//            return lruMap.get(key);
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//            if (lruMap.size() >= mapCapacity && !lruMap.containsKey(key)) {
//                int toDelete = queue.poll();
//                lruMap.remove(toDelete);
//            }
//            if(!queue.contains(key)) queue.offer(key);
//            else{
//                queue.remove(key);
//                queue.offer(key);
//            }
//                lruMap.put(key, value);
//    }
//
//    public static void main(String[] args) {
//        LRUCache cache = new LRUCache(2);
////        cache.put(1, 1);
////        cache.put(2, 2);
////        System.out.println(cache.get(1));     // 返回  1
////        cache.put(3, 3);    // 该操作会使得密钥 2 作废
////        System.out.println(cache.get(2));      // 返回 -1 (未找到)
////        cache.put(4, 4);    // 该操作会使得密钥 1 作废
////        System.out.println(cache.get(1));      // 返回 -1 (未找到)
////        System.out.println(cache.get(3));       // 返回  3
////        cache.get(4);       // 返回  4
////        cache.get(2);
////        cache.put(2,6);
////        cache.get(1);
////        cache.put(1,5);
////        cache.put(1,2);
////        cache.get(1);
////        System.out.println(cache.get(2));
//        cache.put(2,1);
//        cache.put(1,1);
//        cache.put(2,3);
//        cache.put(4,1);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//    }
//}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */