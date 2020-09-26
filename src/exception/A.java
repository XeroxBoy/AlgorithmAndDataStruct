package exception;

public class A {
    public static void ssb() {
        while (true) {
            try {
                B.ssg();
            } catch (xianggeException e) {
                System.out.println("你哈");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("sb");
            }
            System.out.println("successfully reach");
        }

    }

    public static void main(String[] args) {
        A.ssb();
    }
}
