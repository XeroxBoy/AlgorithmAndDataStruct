package company;

import java.util.Scanner;

public class mt2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int[] num=new int[T];
        for(int i = 0; i<T; i++){
            num[i]=sc.nextInt();

        }
        for(int i = 0; i<T; i++){
            System.out.println(sumOfbyte(num[i]));

        }
    }

    public static int sumOfbyte(int x){
        int length=1;
        if(x==0) return 1;
        int sum=0;

        StringBuilder str=new StringBuilder();
        int numLen=testLength(x);


        for(int i=1; i<=x; i++){
            numLen=testLength(i);
            if(numLen>5){
                for(int j=1; j<numLen; j++){
                    if(j!=1){
                        str.append("9");
                    } else str.append("8");
                }
                Integer.valueOf(str.toString());
            }
            sum+=numLen;
        }

        return sum;
    }

    public static int testLength(int x){
        int length=1;
        while(x>=10){
            x>>=2;
            length++;
        }
        return length;
    }
}

