package LeetCode.Easy.Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadBinaryWatch {
    private List<String> res = new ArrayList<String>();


    public List<String> greatReadBinaryWatch(int num) {
        List<String> res = new LinkedList<>();
        //直接遍历  0:00 -> 12:00   每个时间有多少1
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (count1(i) + count1(j) == num)
                    res.add(i + ":" + (j < 10 ? "0" + j : j));
            }
        }
        return res;
    }

    /**
     * 计算二进制中1的个数
     * @param n
     * @return
     */
    int count1(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public List<String> readBinaryWatch(int num) {
        int[] stat = new int[10];
        sub(num, 0, 0, stat);
        return res;
    }

    // “n个数中选k个数” 的变形问题
    // 可以理解为从10个位置中取num个位置的组合问题
    // int[] stat 的前四位表示小时，后六位表示分钟
    // 通过回溯选出所有的组合
    private void sub(int num, int start, int cnt, int[] stat){
        if(cnt == num){
            int hour = stat[0]*8+stat[1]*4+stat[2]*2+stat[3];
            int minu = stat[4]*32+stat[5]*16+stat[6]*8+stat[7]*4+stat[8]*2+stat[9];
            if(hour<12 && minu<60){
                String s = String.format("%d:%02d", hour, minu);
                res.add(s);
            }

            return;
        }

        // 剪枝  i<=9 ----> i<=9-(num-cnt)+1
        for(int i=start; i<=(9-(num-cnt)+1); i++){
            stat[i] = 1;
            sub(num, i+1, cnt+1, stat);
            stat[i] = 0;
        }

    }
}

