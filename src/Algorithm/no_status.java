package Algorithm;

public class no_status {
    private static boolean isFucked = false;

    public void setIsFucked(boolean fuck) {
        isFucked = fuck;
    }

    public int fucker() {
        if (isFucked) return 3;
        return 2;
    }
}
