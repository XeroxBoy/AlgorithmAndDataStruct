package LeetCode.Easy.Trick;

import java.math.BigInteger;

public class TrailingZeroes {
    public int trailingZeroes(int n){

        BigInteger result = trail(n);
        int zeroCount = 0;
        while(result.compareTo(BigInteger.valueOf(0)) > 0){
            if(result.remainder(BigInteger.valueOf(10)).equals(BigInteger.valueOf(0)))
            {zeroCount++;result = result.divide(BigInteger.valueOf(10));}
            else break;
        }
        return zeroCount;
    }
    public BigInteger trail(int n){
        BigInteger i = BigInteger.valueOf(1);
        for (int j = n; j > 0 ; j--) {
            i = i.multiply(BigInteger.valueOf(j));
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new TrailingZeroes().trailingZeroes(3950));
    }
}

