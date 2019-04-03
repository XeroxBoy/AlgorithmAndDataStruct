package nowcoder;

public class matcher {
    public static boolean match(char[] str,char[] pattern){
        if(str.length==0 && pattern.length==0) return true;
        if(str.length==0){
            for(int m=0;m<pattern.length;m++){
                if(pattern[m]!='*') return false;
            }
        }
        int i=0,j=0;
        while(i<str.length && j<pattern.length){
            if(str[i]==pattern[j]){
                i++;j++;
            }
            else if(pattern[j]=='*'){
                j-=1;
                while(str[i]==pattern[j]){
                    i++;
                }
                if(j+2<pattern.length)
                j+=2;
                else return true;
            }
            else if(pattern[j]=='.'){
                if(j+1<pattern.length) {
                    if(pattern[j+1]!='*'){
                    j++;
                    i++;continue;}

                }
                i++;
                j++;
            }
            else if(str[i]!=pattern[j]){
                if(j+1==pattern.length ) return false;
                if(pattern[j+1]=='*'){
                    j++;
                }
                else return false;
            }
        }
        if(i==str.length && j==pattern.length)
        return true;
        else return false;
    }
    public static void main(String[] args){
        String str="aaa";
        String pattern1="a.a";
        String pattern2="ab*ac*a";
        String pattern3="aa.a";
        String pattern4="ab*a";
        System.out.println(match(str.toCharArray(),pattern1.toCharArray()));
        System.out.println(match(str.toCharArray(),pattern2.toCharArray()));
        System.out.println(match(str.toCharArray(),pattern3.toCharArray()));
        System.out.println(match(str.toCharArray(),pattern4.toCharArray()));

    }
}
