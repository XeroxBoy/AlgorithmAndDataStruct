package LeetCode.Easy.String;

public class BackSpaceCompare {
    public static void main(String[] args) {
        BackSpaceCompare backSpaceCompare = new BackSpaceCompare();
        System.out.println(
                backSpaceCompare.backspaceCompare("ab#c", "ad#c"));
        System.out.println(
                backSpaceCompare.backspaceCompare("ab##", "c#d#")
        );
        System.out.println(backSpaceCompare.backspaceCompare("a##c", "#a#c"));
        System.out.println(
                backSpaceCompare.backspaceCompare("xywrrmp", "xywrrmu#p")
        );
    }

    public boolean backspaceCompare(String S, String T) {
        String s_back = get_str_back(S);
        String t_back = get_str_back(T);
        return s_back.equals(t_back);
    }

    private String get_str_back(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char oneChar = str.charAt(i);
            if (oneChar != '#')
                sb.append(oneChar);
            int j = i + 1;
            boolean hasJin = false;
            while (j < str.length() && str.charAt(j) == '#') {
                j++;
                hasJin = true;
            }
            if (hasJin) {
                int to_delete = j - i - 1;
                while (to_delete-- > 0 && sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                i = j - 1;
            }
        }
        return sb.toString();
    }
}
