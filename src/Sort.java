public class Sort {
    static int times=0;
    public static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void quickSort(int[] a,int low,int high){
        if(low>=high) return;
        int index=partition(a,low,high);
        quickSort(a,low,index-1);
        quickSort(a,index+1,high);
    }

    public static int partition(int[] a,int low,int high){
        int flag=a[low];//取出标杆元素
        int i=low,j=high+1;
        while(j>i){
            while(flag>a[++i]){
                if(i==high) break;
            }
            while(flag<a[--j]){
                if(j==low) break;
            }
            if(i>j) break;
            swap(a,i,j);
        }
        swap(a,low,j);
        System.out.println("第"+ ++times+"次快速排序结果");
        for(int m=0;m<a.length;m++){

            System.out.print(a[m]+" ");
        }
        System.out.println();
        return j;
    }
    public static void bubbleSort(int []a,int low,int high){
        if(low>=high) return;
        for(int i=low;i<high;i++){
            for(int j=0;j<high;j++){
                if(a[j]>a[j+1]) swap(a,j,j+1);
            }
        }
    }
    public static void selectSort(int[] a,int low,int high){
        if(low>=high) return;
        for(int i=low;i<high;i++){
            int min=a[i];
            int minIndex=i;
            for(int j=i+1;j<=high;j++){
                if(a[j]<min) {
                    min=a[j];
                    minIndex=j;
                }
            }
            swap(a,minIndex,i);
        }
    }
    public static void insertSort(int[] a,int low,int high){
        for(int i=low+1;i<=high;i++){
            for(int j=i;j>low;j--){
                if(a[j]<a[j-1]) swap(a,j-1,j);
            }
        }
    }
    public static void heapSort(int []a){
        for(int i=a.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(a,i,a.length);
        }
        for(int j=a.length-1;j>0;j--){
            swap(a,0,j);//把大的放后面，实现排序
            adjustHeap(a,0,j);
        }
    }
    public static void adjustHeap(int []a,int start,int length){
        int temp=a[start];//取出当前元素
        for(int k=2*start+1;k<length;k=k*2+1){
            if(k+1<length && a[k+1]>a[k]) k+=1;//右儿子大
            if(a[k]>temp) {
                a[start]=a[k];
                start=k;
            }
            else break;
        }
        a[start]=temp;
    }
}

