package nowcoder;

public class FirstAppearingOnce {
    StringBuilder str = new StringBuilder();

    //Insert one char from stringstream
    public void Insert(char ch) {
        str.append(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        String str0 = str.toString();
        char[] chars = str0.toCharArray();
        if (chars.length == 0) return '#';
//        boolean notOnce = false;
        for (int i = 0; i < chars.length; i++) {
            char[] otherChars = new char[chars.length - 1];
            for (int m = 0, n = 0; m < otherChars.length; m++, n++) {
                if (n != i) otherChars[m] = chars[n];
                if (n == i) m -= 1;
            }
            String otherStr = String.valueOf(otherChars);
            System.out.println(otherStr);
            if (otherStr.indexOf(chars[i]) == -1) return chars[i];
        }
        return '#';
    }

    public static void main(String[] args) {
        FirstAppearingOnce fs = new FirstAppearingOnce();
        fs.Insert('g');
        fs.Insert('o');
        fs.Insert('o');
        fs.Insert('g');
//        fs.Insert('l');
//        fs.Insert('e');
        System.out.println(fs.FirstAppearingOnce());
    }
}

