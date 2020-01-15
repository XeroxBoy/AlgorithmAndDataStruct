package Algorithm;

import java.util.*;

public class SelectZhangJie {
    public static void main(String[] args) {
        String[] peoples = {"宋翔", "邹峰", "苏自鹏", "李凯", "王浩漪", "郭晓宇", "陈可欣", "徐帅"};
        Map<String, Double> score = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            double comparableNum = Math.floor(Math.random() * 100000);
            score.put(peoples[i], comparableNum);
        }
        int size = score.size();
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(size);
        list.addAll(score.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

            ;
        });
        for (Map.Entry<String, Double> entry : list) {
            // 得到排序后的键值
            System.out.println(entry.getKey());
        }
    }
}

