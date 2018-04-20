
public class Main {

    public static void main(String[] args) {
       // System.out.println("Hello World!");
        int []a={9,8,7,6,5,4,3,2,1,12,14,15,16,11};
        System.out.println("初始数据：");
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
        Sort.quickSort(a,0,a.length-1);
      //  Sort.bubbleSort(a,0,a.length-1);
       // Sort.selectSort(a,0,a.length-1);
        //Sort.insertSort(a,0,a.length-1);
       // Sort.heapSort(a);
        System.out.println("排序后数据：");
        for(int i=0;i<a.length;i++)
        System.out.print(a[i]+" ");
    }
}
