package LeetCode.Easy.String;

public class StrStr {
    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("aaa", "aa"));
    }

    /*
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出
     * needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * */
    public int strStr(String haystack, String needle) {
        if (needle.trim().equals("")) return 0;
        // return haystack.indexOf(needle);
        char[] hayArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        int indexOfNeedle = -1;
        for (int i = 0; i < hayArray.length; i++) {
            if (hayArray[i] == needleArray[0]) {
                for (int j = 0; j < needleArray.length; j++) {
                    if (i + j >= hayArray.length) return -1;
                    if (hayArray[i + j] != needleArray[j]) break;
                    if (j == needleArray.length - 1) indexOfNeedle = i;
                }
                if (indexOfNeedle != -1) break;
            }
        }
        return indexOfNeedle;
    }
}
