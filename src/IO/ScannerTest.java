package IO;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        System.out.println("next:" + next);
        String nextString = sc.nextLine();
        System.out.println("nextLine" + nextString);
    }
}
