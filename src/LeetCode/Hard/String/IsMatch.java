package LeetCode.Hard.String;

public class IsMatch {
    //    public boolean isMatch(String s, String p) {
//        int sIndex = 0;
//        for (int i = 0; i < p.length(); i++) {
//            char eachChar = p.charAt(i);
//            if(eachChar ==  '.') {
//                if(i+1>=p.length()) break;
//                char nextChar = p.charAt(i+1);
//                if(nextChar=='*'){
//                    char beginChar = s.charAt(sIndex);
//                 while(sIndex+1< s.length() && s.charAt(sIndex+1) == beginChar) sIndex++;
//                 continue;
//                }
//                sIndex +=1;
//                continue;}
//            if(eachChar != '*') {
//                if(i+1>=p.length()) break;
//                char nextChar = p.charAt(i+1);
//                if(nextChar == '*'){
//                    while(s.charAt(sIndex)==eachChar)sIndex++;
//                    continue;
//                }
//                if(nextChar == '.') {sIndex+=1;i++;continue;}
//                else{
//                    if(s.charAt(sIndex)!=eachChar) return false;
//                }
//            }
//        }
//        if(sIndex<s.length()) return false;
//        return true;
//    }
    public boolean greatIsMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] memory = new boolean[sLen + 1][pLen + 1];
        memory[0][0] = true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    memory[i][j] = memory[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) ||
                            p.charAt(j - 2) == '.') && memory[i - 1][j]);
                } else {
                    memory[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                            && memory[i - 1][j - 1];
                }
            }
        }
        return memory[sLen][pLen];
    }

    public boolean greatGreatIsMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] memory = new boolean[2][pLen + 1];
        memory[0][0] = true;
        int cur = 0, pre = 0;
        for (int i = 0; i <= sLen; i++) {
            cur = i % 2;
            pre = (i + 1) % 2;
            if (i > 1) {
                for (int j = 0; j <= pLen; j++) {
                    memory[cur][j] = false;
                }
            }
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {

                    memory[cur][j] = memory[cur][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) ||
                            p.charAt(j - 2) == '.') && memory[pre][j]);
                } else {
                    memory[cur][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                            && memory[pre][j - 1];
                }
            }
        }
        return memory[cur][pLen];
    }

}
