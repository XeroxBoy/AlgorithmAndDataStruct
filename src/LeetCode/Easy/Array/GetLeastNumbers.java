package LeetCode.Easy.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    public static void main(String[] args) {
        Arrays.stream(new GetLeastNumbers().getLeastNumbers(new int[]{3, 2, 1}, 2)).forEach(System.out::println);
        Arrays.stream(new GetLeastNumbers().getLeastNumbers(new int[]{0, 0, 2, 0, 5}, 0)).forEach(System.out::println);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0)
            return new int[0];
        int low = 0, high = arr.length - 1;
        return quickSort(arr, low, high, k - 1);
    }

    private int[] quickSort(int[] arr, int low, int high, int k) {
        int flag = partition(arr, low, high);
        if (flag == k) {
            return Arrays.copyOf(arr, flag + 1);
        }
        return flag > k ? quickSort(arr, low, flag - 1, k) : quickSort(arr, flag + 1, high, k);
    }

    private int partition(int[] arr, int low, int high) {
        int flagNumber = arr[low];
        int i = low, j = high + 1;
        while (true) {
            while (--j >= low && arr[j] > flagNumber) ;
            while (++i <= high && arr[i] < flagNumber) ;
            if (i >= j) break;
            swap(arr, i, j);
        }
        arr[low] = arr[j];
        arr[j] = flagNumber;
        return j;
    }

    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
