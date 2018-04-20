import java.util.Scanner;

public class mt {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int sum=0;
        int N=sc.nextInt();
        int[] A=new int[N];
        int n=sc.nextInt();
        int m=sc.nextInt();
        int p=sc.nextInt();
        A[0]=p;
        for(int i=1;i<N;i++){
            A[i]=(A[i-1]+153)%p;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            sum+=A[gcd(i+1,j+1)];
            }
        }
        System.out.println(sum);
    }
    public static int gcd(int x,int y){

        int result=1;
        int temp=x>y?y:x;
        for(int m=temp;m>0;m--){
            if(x%m==0 && y%m==0){
                result=m;break;
            }
        }

        return result-1;
    }


}

