package dataStructure;

public class VersionControl {
    public static boolean isBadVersion(int version) {
        if (version < 4) return false;
        return true;
    }
}
