package company.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class maxTaxiNum {
    static int maxTaxiNum = 0;
    static int stopNum = 0;

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        maxTaxiNum = 0;
        Scanner sc = new Scanner(System.in);
        stopNum = sc.nextInt();
        int guestNum = sc.nextInt();
        int[] startTime = new int[guestNum];
        int[] startStopId = new int[guestNum];
        int[] endStopId = new int[guestNum];
        int[] endTime = new int[guestNum];
        Arrays.fill(endTime, -1);
        for (int i = 0; i < guestNum; i++) {
            startTime[i] = sc.nextInt();
            startStopId[i] = sc.nextInt();
            endStopId[i] = sc.nextInt();
            int nowTime = startTime[i];
            int nowDistance = getShortestDistance(startStopId[i], endStopId[i]);
            int nowEndTime = nowTime + nowDistance * 5;
            int sameNum = 1;
            for (int j = 0; j < i; j++) {
                int otherEndTime = endTime[j];
                int otherStartTime = startTime[j];
                if (otherEndTime == -1) {
                    int otherStartStop = startStopId[j];
                    int otherEndStop = endStopId[j];
                    int otherDistance = getShortestDistance(otherStartStop, otherEndStop);
                    otherEndTime = otherStartTime + otherDistance * 5;
                    endTime[j] = otherEndTime;
                }
                if (otherEndTime > nowTime && otherStartTime <= nowEndTime) {
                    sameNum += 1;
                }
            }
            maxTaxiNum = Math.max(sameNum, maxTaxiNum);
        }
        System.out.println(maxTaxiNum);
    }
// 0 0 15
    // 10 10 11
    //15 20 40

    // 10 3
    // 0 0 1
    // 5 0 9
    //10 0 1
    private static int getShortestDistance(int startStop, int endStop) {
        int forwardDis;
        int backwardDis;
        if (endStop > startStop) {
            forwardDis = endStop - startStop;
            backwardDis = startStop + (stopNum - endStop);
        } else {
            forwardDis = stopNum - startStop + endStop;
            backwardDis = startStop - endStop;
        }
        return Math.min(forwardDis, backwardDis);
    }

}
