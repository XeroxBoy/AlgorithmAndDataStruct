package company.huawei;

import java.util.*;

public class MaxLink {
    static class Edge {
        int start;
        int end;
        int val;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return start == edge.start && end == edge.end && val == edge.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, val);
        }
    }

    static int maxPathLen = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        if (data.length() < 2) return;

        String realData = data.substring(1, data.length() - 1).replaceAll("\\[", "");
        String[] values = realData.split("]");
        LinkedList<Edge> edgeList = new LinkedList<>();

        for (int i = 1; i < values.length; i++) {
            values[i] = values[i].substring(1);
            String[] edgeVal = values[i].split(",");
            Edge edge = new Edge();
            edge.start = Integer.parseInt(edgeVal[0]);
            edge.end = Integer.parseInt(edgeVal[1]);
            edge.val = Integer.parseInt(edgeVal[2]);
            edgeList.add(edge);
        }
        Set<Edge> edgeSet = new HashSet<>();
        for (Edge edge : edgeList) {
            int end = edge.end;
            int val = edge.val;
            edgeSet.add(edge);
            traverse_find_max_path(end, val, edgeSet, edgeList);
            edgeSet.remove(edge);
        }
        System.out.println(maxPathLen);
    }

    private static void traverse_find_max_path(int end, int nowLen, Set<Edge> edgeSet, LinkedList<Edge> edgeList) {
        maxPathLen = Math.max(maxPathLen, nowLen);
        for (Edge oneEdge : edgeList) {
            if (oneEdge.start == end && !edgeSet.contains(oneEdge)) {
                edgeSet.add(oneEdge);
                traverse_find_max_path(oneEdge.end, nowLen + oneEdge.val, edgeSet, edgeList);
                edgeSet.remove(oneEdge);
            }
        }
    }
}
