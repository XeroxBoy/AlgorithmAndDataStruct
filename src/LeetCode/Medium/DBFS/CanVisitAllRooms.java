package LeetCode.Medium.DBFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CanVisitAllRooms {
    static HashSet<Integer> roomSet;

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> third = new ArrayList<>();
        List<Integer> fourth = new ArrayList<>();
        first.add(1);
        first.add(3);
        second.add(3);
        second.add(0);
        second.add(1);
        third.add(2);
        fourth.add(0);
        rooms.add(first);
        rooms.add(second);
        rooms.add(third);
        rooms.add(fourth);
        boolean num = new CanVisitAllRooms().canVisitAllRooms(rooms);
        System.out.println(num);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        roomSet = new HashSet<>();
        List<Integer> keys = rooms.get(0);
        roomSet.add(0);
        start_visit(keys, rooms);
        return roomSet.size() == rooms.size();
    }

    private void start_visit(List<Integer> keys, List<List<Integer>> rooms) {
        for (Integer key : keys) {
            if (!roomSet.contains(key)) {
                roomSet.add(key);
                List<Integer> nextKeys = rooms.get(key);
                start_visit(nextKeys, rooms);
            }
        }
    }
}
