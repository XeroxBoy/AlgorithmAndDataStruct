package LeetCode.Easy;

public class AddBinary {
    public static void main(String[] args) {
//        System.out.println(new AddBinary().addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
//                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    public String addBinary(String a, String b) {
        long maxLen = Math.max(a.length(), b.length());
        int numFlag = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            int abinary = 0;
            int bbinary = 0;
            if (a.length() - 1 - i < 0 && b.length() - 1 - i < 0) break;
            if (a.length() - 1 - i >= 0)
                abinary = a.charAt(a.length() - 1 - i) == '0' ? 0 : 1;
            if (b.length() - 1 - i >= 0)
                bbinary = b.charAt(b.length() - 1 - i) == '0' ? 0 : 1;
            System.out.println(bbinary);
            int numbinary = abinary + bbinary;
            if (numFlag == 1) {
                numbinary += numFlag;
                numFlag = 0;
            }
            if (numbinary == 2 || numbinary == 3) {
                numbinary = numbinary % 2;
                numFlag = 1;
            }
            result.append(numbinary);
        }
        if (numFlag == 1) result.append('1');
        return result.reverse().toString();
    }

    public String greatAddBinary(String a, String b) {
        char[] aArry = a.toCharArray();
        char[] bArry = b.toCharArray();
        char[] cArry = new char[Math.max(aArry.length, bArry.length)];
        boolean carry = false;
        boolean fCarry = false;
        for (int i = aArry.length - 1, j = bArry.length - 1, l = cArry.length - 1; i >= 0 || j >= 0; i--, j--, l--) {
            char ac = 0;
            char bc = 0;
            if (i < 0) {
                ac = 48;
            } else {
                ac = aArry[i];
            }
            if (j < 0) {
                bc = 48;
            } else {
                bc = bArry[j];
            }
            if (carry) {
                ac += 1;
                carry = false;
            }
            int c = ac + bc;
            if (c >= 98) {
                carry = true;
                c -= 2;
                if (l == 0) {
                    fCarry = true;
                }
            }
            c -= 48;
            cArry[l] = (char) c;
        }
        String result = new String(cArry);
        if (fCarry) {
            result = "1" + result;
        }
        return result;
    }

    public String greatTWOaddBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int carry = 0, i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) carry += a.charAt(i--) - '0';
            if (j >= 0) carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}
