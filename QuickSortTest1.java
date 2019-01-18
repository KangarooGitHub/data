package com.tendcloud.es.es_java_api;

import java.util.Arrays;

/**
 * QuickSort
 *
 * @author panxing.fu
 * @create 2019-01-02 10:24
 **/
public class QuickSortTest1 {
    public static void main(String[] args) {
        int [] a = {11,-1,-10,4,3,2,8,20,9,30,10};
        quickSort(a,0,a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] array, int low, int high){
        if (low <= high)
        {
            int mid = QuickSortTest1.partition(array,low,high);
            QuickSortTest1.quickSort(array,low,mid -1);
            QuickSortTest1.quickSort(array,mid + 1,high);
        }
    }
    private static int partition(int [] array,int low, int high){
        int key= array[low];
        while (low < high) {
            while (low < high && array[high] >= key ) {
                high --;
            }
            swap(array,low,high);
            while (low< high && array[low] <= key){
                low ++;
            }
            swap(array,low,high);
        }
        return low;
    }
    private static void swap(int[] array,int i , int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
