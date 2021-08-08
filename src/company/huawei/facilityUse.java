package company.huawei;

import java.lang.reflect.Array;
import java.util.*;

public class facilityUse {
    static class Mission {
        int startTime;
        int endTime;
        int time;
        int prior;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int availableFac = sc.nextInt();
        int testFac = sc.nextInt();
        ArrayList<Mission> missions = new ArrayList<>();
        for (int i = 0; i < testFac; i++) {
            Mission oneMission = new Mission();
            oneMission.time = sc.nextInt();
            oneMission.prior = sc.nextInt();
            missions.add(oneMission);
        }
        missions.sort((o1, o2) -> {
            if (o1.prior == o2.prior) {
                return o2.time - o1.time;
            }
            return o1.prior - o2.prior;
        });
        ArrayList<Mission> missionQueue = new ArrayList<>();
        if (missions.size() == 0) {
            System.out.println(0);
            return;
        }
        int missionIndex = 0;
        missions.get(0).startTime = 0;
        missions.get(0).endTime = missions.get(0).time;
        missionQueue.add(missions.get(missionIndex));
        missionIndex++;
        int nowTime = 0;
        while (missionQueue.size() != 0) {
            for (int i = 0; i < missionQueue.size(); i++) {
                if (missionQueue.get(i).endTime >= nowTime) missionQueue.remove(missionQueue.get(i));
            }
            while (missionQueue.size() < availableFac && missionIndex < missions.size()) {
                Mission oneMission = missions.get(missionIndex);
                oneMission.startTime = nowTime;
                oneMission.endTime = oneMission.startTime + oneMission.time;
                missionQueue.add(missions.get(missionIndex));
            }
            if (missionQueue.size() > 0)
                nowTime++;
        }
        System.out.println(nowTime);
    }
}
