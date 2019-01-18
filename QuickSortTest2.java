package com.tendcloud.es.es_java_api;

import java.util.Arrays;

/**
 * QuickSort
 *
 * @author panxing.fu
 * @create 2019-01-02 12:36
 **/
public class QuickSortTest2 {
    public static void main(String[] args) {
        int[] a = {11,-1,-10,4,3,2,8,20,9,30,10};
        quickSort(a,0,a.length -1 );
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a,int low,int high){
        if(low<=high) { //递归退出条件，快速排序是原地排序，就是在乱序数组上直接排序，不需要新建其他临时数组，
                        //同时也是不断缩小排序范围的，当缩小到只需要对2个数字排序的时候，排序完成后，乱序数组就有序了。
            int mid = partition(a,low,high);
            quickSort(a,low,mid -1);
            quickSort(a,mid +1 ,high);
        }
    }

    private static int partition(int[] a,int low,int high){
        int key = a[low];//优化点1，一般都是取最左边的数作为比较对象，如果能优化到取中间某个数作为比较对象，则会减少比较，交换次数，仅仅修改low和high的值即可
        while (low<high) { //防止数组没有遍历完，意思是，找到第一个小于Key的值，交换后，找到第一个大于Key的值，
                            // 如果不继续，则不会达到一部分数据全小于Key，一部分数据全大于Key的目的。
            while (low < high && a[high] >= key){ //防止数组下标越界，因为假如数组已经有序，high不停减少，会出现a[high]下标访问越界
                high--;
            }
            swap(a,low,high);
            while (low< high && a[low] <= key){ //防止数组下标越界，因为假如数组已经有序，low不停增加，会出现a[low]下标访问越界
                low++;
            }
            swap(a,low,high);
        }
        //System.out.println("low: " + low + " high: " + high);
        return low; //此处返回low后者high都行，因为low和high相等
    }
    private static void swap(int[] a, int i, int j){
        //System.out.println("swap: " + a[i] + " " + a[j]);
        //优化点2，假如序列已经有序，最后的low和high相等，就不需要再交换
        if(a[i] != a[j]) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
