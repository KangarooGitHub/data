package com.abssqr.session.utils;

import java.util.Arrays;

/**
 * QuickSort
 *
 * @author panxing.fu
 * @create 2019-01-02 10:24
 **/
public class QuickSortTestFinal {
    public static void main(String[] args) {
        int [] a = {11,-1,-10,4,3,2,8,20,9,30,10};
        quickSort(a,0,a.length - 1);
        System.out.println(Arrays.toString(a));
       /* int x = 1;
        int y = 1;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;*/
        //System.out.println(x);
        //System.out.println(y);
        //System.out.println(1^0);
    }

    private static void quickSort(int[] array, int low, int high){
        if (low < high)
        {
            int mid = QuickSortTestFinal.partition(array,low,high);
            QuickSortTestFinal.quickSort(array,low,mid -1);
            QuickSortTestFinal.quickSort(array,mid + 1,high);
        }
    }
    private static int partition(int [] array,int low, int high){
        int key= array[low];
        while (low < high) {
            while (low <= high && array[high] > key ) {
                high --;
            }
            swap(array,low,high);
            while (low<= high && array[low] < key){
                low ++;
            }
            swap(array,low,high);
        }
        return low;
    }
    private static void swap(int[] array,int i , int j) {
        if(i != j) {
            array[i] = array[i] ^ array[j];
            array[j] = array[i] ^ array[j];
            array[i] = array[i] ^ array[j];
        }
        /*int temp = array[i];
        array[i] = array[j];
        array[j] = temp;*/
    }
}
