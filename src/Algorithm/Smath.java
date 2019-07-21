package Algorithm;

import java.util.Scanner;

public class Smath {
    public static double pow1(int a,long b){
       return Math.pow(a,b);
    }
    static void cut(int n){
        double y=1.0;
        for(int i=0;i<=n;i++){
            double π=3*Math.pow(2, i)*y;
            System.out.println("第"+i+"次切割,为正"+(6+6*i)+"边形，圆周率π≈"+π);
            y=Math.sqrt(2-Math.sqrt(4-y*y));
        }
    }
    static double jishuPI(double z){
        double sum=2;
        int n=1;
        int m=3;
        double t=2;
        while(t>z){
            t=t*n/m;
            sum=sum+t;
            n++;
            m+=2;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(Math.PI);
        while(true) {
          /*  System.out.println("输入a");

            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();     if(a==-555) return ;
            System.out.println("输入b");

            int b= sc.nextInt();
            String s = new BigInteger(String.valueOf(a)).pow(b).toString();


            System.out.println(s);
            System.out.println("输入-555结束");*/
            System.out.println("输入a");

            Scanner sc = new Scanner(System.in);
            double a = sc.nextDouble();
          // cut(a);
            System.out.println(jishuPI(a));

        }
    }
}

