package company.huawei;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 示例 1:
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 * 示例 3:
 * 输入: s = "abc"
 * 输出: false
 * 0123
 * abba length = 4
 * <p>
 * 012
 * aba length=3
 */
public class huiwen {
    public boolean judgeHuiWen(String s) {
        boolean isHuiwenStr = false;
        isHuiwenStr |= isHuiwen(s);
        for (int i = 0; i < s.length(); i++) {
            String toJudge = s.substring(0, i) + s.substring(i + 1);
            isHuiwenStr |= isHuiwen(toJudge);
            if (isHuiwenStr) {
                return true;
            }
        }
        return false;
    }

    private boolean isHuiwen(String toJudge) {
        int length = toJudge.length();
        if (length == 0) return true;
        if (length % 2 == 0) {
            int leftStart = length / 2 - 1;
            int rightStart = length / 2;
            while (leftStart >= 0 && rightStart < length) {
                if (toJudge.charAt(leftStart) != toJudge.charAt(rightStart)) {
                    return false;
                }
                leftStart--;
                rightStart++;
            }
        } else {
            int start = length / 2;
            int leftStart = start - 1;
            int rightStart = start + 1;
            while (leftStart >= 0 && rightStart < length) {
                if (toJudge.charAt(leftStart) != toJudge.charAt(rightStart)) {
                    return false;
                }
                leftStart--;
                rightStart++;
            }
        }
        return true;
    }

    /**
     * * 示例 1:
     * * 输入: s = "aba"
     * * 输出: true
     * * 示例 2:
     * * 输入: s = "abca"
     * * 输出: true
     * * 解释: 你可以删除c字符。
     * * 示例 3:
     * * 输入: s = "abc"
     * * 输出: false
     *
     * @param args
     */
    public static void main(String[] args) {
        String a = "aba";
        String b = "abca";
        String c = "abc";
        System.out.println(new huiwen().judgeHuiWen(a));
        System.out.println(new huiwen().judgeHuiWen(b));
        System.out.println(
                new huiwen().judgeHuiWen(c)
        );
    }
}
