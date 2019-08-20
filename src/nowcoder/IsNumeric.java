package nowcoder;

public class IsNumeric {
    public boolean isNumeric(char[] str) {
        String strs = String.valueOf(str);
        return strs.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([Ee][\\+-]?[0-9]+)?");
    }

    public static void main(String[] args) {
        IsNumeric isN = new IsNumeric();
        System.out.println(isN.isNumeric(("1E2").toCharArray()));
        System.out.println(isN.isNumeric(("1E").toCharArray()));
        System.out.println(isN.isNumeric(("+-5").toCharArray()));
    }
}

