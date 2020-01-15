package LeetCode.Medium.String;

public class LongestPalindrome {
    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    public static void main(String[] args) {
        String sb = "ababa";
        System.out.println(new LongestPalindrome().longestPalindrome(sb));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }
}
///****************  动态规划  ****************/
//class Solution {
//    /**
//     * @param String s
//     * @return String
//     */
//    function longestPalindrome(s) {
//        len = strlen(s);
//        if(len < 2) return s;         //初始化判断
//        dp = [];                       //初始化动态规划dp数组，dp[i][j]表示从j到i的字符串是否为回文串
//        right = left = 0;             //初始化最长的最优节点
//        for(i=0;i<len;++i){
//            dp[i][i] = true;         //只有一个元素的时候肯定为true
//            for(j=i-1;j>=0;--j){    //遍历到第i个元素，再倒退判断是否为回文串
//                //头i尾j两个元素相等，且dp[i-1][j+1]是回文串，即dp[i][j]也是回文串
//                //特殊情况,“bb”,此时dp[i-1][j+1]=dp[j][i]此时数组不成立，不存在截取的反向字符串
//                dp[i][j] = s[i] == s[j] && (i-j==1 || dp[i-1][j+1]);
//                if(dp[i][j] && (i-j)>(right-left)){
//                    right = i;        //截取的字符串的长度大于之前求得的左右长度，则取的左右下标点
//                    left = j;
//                }
//            }
//        }
//        return substr(s,left,right-left+1); //截取字符串
//    }
//}

