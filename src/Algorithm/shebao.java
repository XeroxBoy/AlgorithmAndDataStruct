package Algorithm;

import java.util.Scanner;

public class shebao {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int aS=sc.nextInt();
        int aJ=sc.nextInt();
        //  aJ=(450*18+700*5)/23;
        int years=sc.nextInt();
        System.out.println(calSBao(aS,aJ,years));

    }

    public static double calSBao(int averageSalary, int averageJiao, int years){
        double result=averageSalary*years*0.01+averageJiao*12*years/139;
        return result;

    }
}

