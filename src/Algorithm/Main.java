package Algorithm;

public class Main {

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        // int []a={9,8,7,6,5,4,3,2,1,12,14,15,16,11,10};
        //int []a={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int []a={15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        System.out.println("初始数据：");
        for(int i = 0; i<a.length; i++)
            System.out.print(a[i]+" ");
        System.out.println();
        Sort.quickSort(a,0,a.length-1);
        //  Algorithm.Sort.bubbleSort(a,0,a.length-1);
        // Algorithm.Sort.selectSort(a,0,a.length-1);
        //Algorithm.Sort.insertSort(a,0,a.length-1);
        // Algorithm.Sort.heapSort(a);
        System.out.println("排序后数据：");
        for(int i = 0; i<a.length; i++)
            System.out.print(a[i]+" ");

        int target=1; System.out.println();
        System.out.println("查找target结果为：");
        System.out.println(Sort.erFenSearch(a,target));
    }
}
