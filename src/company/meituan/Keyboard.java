package company.meituan;


import java.util.Scanner;

public class Keyboard {

    /**
     * 小美得到了一个奇怪的键盘，上面一共有53个按键，包括26个小写字母、26个大写字母和空格。这个键盘的奇怪之处如下：
     * <p>
     * 当小美按下一个按键时，该按键可能会被多次触发，即输出一连串按下按键所对应的字符。
     * <p>
     * 键盘会时不时地自动按下空格键。
     * <p>
     * 在使用这个键盘来进行输入时，小美保证了相邻两次按下的按键一定不同以及不主动按下空格键，现在给你小美使用这个
     * 键盘输入一个字符串后得到的结果，请你还原小美原本想要输入的这个字符串。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll(" ", "");
        str = removeDuplicate(str);
        System.out.println(str);
    }

    private static String removeDuplicate(String str) {
        if (str.length() == 0) return str;
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        char lastDuplicate = str.charAt(0);
        int index = 1;
        while (index < str.length()) {
            while (index < str.length() && str.charAt(index) == lastDuplicate) {
                index++;
            }
            if (index >= str.length()) break;
            lastDuplicate = str.charAt(index);
            sb.append(lastDuplicate);
            index++;
        }
        return sb.toString();
    }
}
