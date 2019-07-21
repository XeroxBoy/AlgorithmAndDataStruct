package company;

import java.util.Scanner;

public class JD {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        int [] Ns=new int[t];
        for(int i=0;i<t;i++){
            Ns[i]=sc.nextInt();
        }
        for(int i=0;i<t;i++) {
            findYZ(Ns[i]);
        }

    }

    public static void testBack(String str){
        int sum=str.length();
        int half=sum/2;

        System.out.println(sum);

    }
    public static void testKuohao(String str){
        char[] st = str.toCharArray();
        int sum=0;
      int left=0,right=0;
        for(int i=0;i<st.length;i++){
         if(st[i]=='(') left++;
            else if(st[i]==')') right++;
            }
        if(left!=right) System.out.println("No");
        else System.out.println("Yes");

        }


    public static void findYZ(int N){
        for(int j=2;j<=N;j+=2){
            for(int i=1;i<=N/j;i+=2){
                if(i*j==N){
                    System.out.println(i+" "+j);
                    return;
                }
            }
        }
        System.out.println("No");

    }

    }

