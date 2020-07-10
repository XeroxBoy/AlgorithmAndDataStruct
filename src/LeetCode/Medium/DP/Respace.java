package LeetCode.Medium.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Respace {
    public static void main(String[] args) {
        String[] dictionary = {"aaysaayayaasyya", "yyas", "yayysaaayasasssy", "yaasassssssayaassyaayaayaasssasysssaaayysaaasaysyaasaaaaaasayaayayysasaaaa", "aya", "sya", "ysasasy", "syaaaa", "aaaas", "ysa", "a", "aasyaaassyaayaayaasyayaa", "ssaayayyssyaayyysyayaasaaa", "aya", "aaasaay", "aaaa", "ayyyayssaasasysaasaaayassasysaaayaassyysyaysaayyasayaaysyyaasasasaayyasasyaaaasysasy", "aaasa", "ysayssyasyyaaasyaaaayaaaaaaaaassaaa", "aasayaaaayssayyaayaaaaayaaays", "s"};
        String sentence = "asasayaayaassayyayyyyssyaassasaysaaysaayaaaaysyaaaa";
        System.out.println(new Respace().respace(dictionary, sentence));
    }

    public int respace(String[] dictionary, String sentence) {
//        ArrayList<String> strList = new ArrayList<String>();
//        for(int i=0;i<dictionary.length;i++){
//            strList.add(dictionary[i]);
//        }
//        strList.sort(Comparator.comparing(String::length).reversed());
//        for(int i=0;i<strList.size();i++){
//            sentence = sentence.replace(strList.get(i),"");
//        }
//        return sentence.length();
        int n = sentence.length();
        Trie root = new Trie();
        for (String word : dictionary) {
            root.insert(word);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            Trie curPos = root;
            for (int j = i; j >= 1; j--) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) break;
                else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) break;
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }

    class Trie {
        public Trie[] next;
        public boolean isEnd;

        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void insert(String s) {
            Trie curPos = this;
            for (int i = s.length() - 1; i >= 0; i--) {
                int t = s.charAt(i) - 'a';
                if (curPos.next[t] == null) {
                    curPos.next[t] = new Trie();
                }
                curPos = curPos.next[t];
            }
            curPos.isEnd = true;
        }
    }
}
