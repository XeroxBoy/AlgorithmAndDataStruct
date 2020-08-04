package LeetCode.Medium.Array;

import java.util.*;

public class CanFinish {
    public static void main(String[] args) {
        System.out.println(new CanFinish().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(new CanFinish().canFinish(2, new int[][]{{1, 0}}));
        System.out.println(new CanFinish().canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}}));
        System.out.println(new CanFinish().canFinish(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));

    }
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[] requirements = new int[numCourses];
//        Arrays.fill(requirements, -1);
//        for (int[] prerequisite : prerequisites) {
//            if (requirements[prerequisite[0]] == -1)
//                requirements[prerequisite[0]] = prerequisite[1];
//            else if (requirements[0] == -1 && requirements[prerequisite[1]] == -1)
//                requirements[prerequisite[1]] = prerequisite[0];
//        }
//        for (int i = 0; i < numCourses; i++) {
//            if (isCircle(requirements, i)) return false;
//        }
//        return true;
//    }
//
//    private boolean isCircle(int[] requirements, int i) {
//        int iterator = i;
//        while (iterator != -1) {
//            iterator = requirements[iterator];
//            if (iterator == i) break;
//        }
//        return iterator == i;
//    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //应该用个二维数组来记录邻接表 ，避免n*m次遍历，性能会更好
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites
        ) {
            indegrees[prerequisite[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            numCourses--;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[0] == node) {
                    if (--indegrees[prerequisite[1]] == 0) queue.offer(prerequisite[1]);
                }
            }
        }
        return numCourses == 0;
    }

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjacency = new ArrayList<>();
            for (int i = 0; i < numCourses; i++)
                adjacency.add(new ArrayList<>());
            int[] flags = new int[numCourses];
            for (int[] cp : prerequisites)
                adjacency.get(cp[1]).add(cp[0]);
            for (int i = 0; i < numCourses; i++)
                if (!dfs(adjacency, flags, i)) return false;
            return true;
        }

        private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
            if (flags[i] == 1) return false;
            if (flags[i] == -1) return true;
            flags[i] = 1;
            for (Integer j : adjacency.get(i))
                if (!dfs(adjacency, flags, j)) return false;
            flags[i] = -1;
            return true;
        }
    }
}
