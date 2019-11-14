package LeetCode.Easy.Trick;

public class GuessGame {
    private int myNum;

    GuessGame(int num) {
        myNum = num;
    }

    public int getMyNum() {
        return myNum;
    }

    public void setMyNum(int myNum) {
        this.myNum = myNum;
    }

    public int guess(int num) {
        if (num == myNum) return 0;
        return num > myNum ? -1 : 1;
    }
}
