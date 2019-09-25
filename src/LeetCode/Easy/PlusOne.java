package LeetCode.Easy;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9};
        int[] newDigit = new PlusOne().plusOne(digits);
        for (int i = 0; i < newDigit.length; i++) {
            System.out.println(newDigit[i]);
        }

    }

    public int[] plusOne(int[] digits) {
        int indexOfDigits = digits.length - 1;
        if (digits[indexOfDigits] != 9) {
            digits[indexOfDigits] = digits[indexOfDigits] + 1;
            return digits;
        }
        boolean flag = true;
        while (indexOfDigits >= 0 && flag) {
            if (digits[indexOfDigits] != 9) flag = false;
            digits[indexOfDigits] = (digits[indexOfDigits] + 1) % 10;
            indexOfDigits--;
        }

        if (indexOfDigits == -1 && flag) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newArray[i + 1] = digits[i];
            }
            return newArray;
        }
        return digits;
    }
}
