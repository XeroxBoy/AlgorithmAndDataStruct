package LeetCode.Easy.Trick;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public boolean isHappy(int n){
        int eachNum = -1;
        int multiplyTimes = 0;
        boolean firstFlag = true;

        while(multiplyTimes<5000) {
            multiplyTimes++;
            while (n != 0) {
                if (firstFlag) {
                    eachNum = 0;
                    firstFlag = false;
                }
                int lastNum = n % 10;
                n /= 10;
                eachNum += Math.pow(lastNum, 2);
            }
            if (eachNum == 1) return true;
            n = eachNum;
            eachNum = 0;
        }
        return false;
    }
    public boolean duplicateIsHappy(int n) {
        Set<Integer> set=new HashSet<>();
        int sumPow=0;
        while(true){
            while(n!=0){
                sumPow+=Math.pow(n%10,2);
                n/=10;
            }
            if(sumPow==1)
                return true;
            if(set.contains(sumPow))
                return false;
            set.add(sumPow);
            n=sumPow;
            sumPow=0;
        }
    }
    public boolean slowFastIsHappy(int n) {
        int fast=n;
        int slow=n;
        do{
            slow=squareSum(slow);
            fast=squareSum(fast);
            fast=squareSum(fast);
        }while(slow!=fast);
        if(fast==1)
            return true;
        else return false;
    }

    private int squareSum(int m){
        int squaresum=0;
        while(m!=0){
            squaresum+=(m%10)*(m%10);
            m/=10;
        }
        return squaresum;
    }
    public static void main(String[] args) {
        System.out.println(new IsHappy().isHappy(3));
    }
}

