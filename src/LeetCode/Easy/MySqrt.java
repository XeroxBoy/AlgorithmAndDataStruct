package LeetCode.Easy;

public class MySqrt {
    public int mySqrt(int x){
        return (int) Math.sqrt(x);
    }
    public int great2MySqrt(int x) {
        if(x<2)
            return x;
        double t = x;
        double x0 = x;
        x0 = x0/2 + t/(2*x0);
        while(x0*x0 - t > 0.00001)
            x0 = x0/2 + t/(2*x0);
        return (int)x0;
    }
    public int greatMySqrt(int x){
        if(x==0 || x==1) return x;
        int low = 0;
        int high = x;
        while(low<=high){
            int mid = (low+high)/2;
            int res1 = f(x,mid);
            int res2 = f(x,mid+1);
            if(res1 == mid || (res1>mid && res2 < mid+1)){
                return mid;
            } else if(res1 < mid){
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return 0;
    }
    public int f(int res,int num){
        return res/num;
    }
    public static void main(String[] args) {
        System.out.println(new MySqrt().greatMySqrt(627));
    }
}

