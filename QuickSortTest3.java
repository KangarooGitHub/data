package com.tendcloud.es.es_java_api;

import java.util.Arrays;

/**
 * QuickSort
 *
 * @author panxing.fu
 * @create 2019-01-02 14:41
 **/
public class QuickSortTest3 {
    public static void main(String[] args) {
        int[] a = {11,-1,-10,4,3,2,8,20,9,30,10};
        int[] a1 = {11,-1,-10,4,3,2,8,20,9,30,10};
        int[] a2 = {11,-1,-10,4,3,2,8,20,9,30,10};
        quickSort(a,0,a.length -1);
        System.out.println(Arrays.toString(a));
        quickSortTopKMax(a1,0,a.length -1,4);
        quickSortTopKMin(a2,0,a2.length - 1,4);
    }
    private static void quickSortTopKMax(int[] a, int low ,int high ,int k) {
        if (low<=high) {
            int mid = partition(a,low,high);
            int gap = high - mid + 1;
            if(gap == k) {
                System.out.println(a[mid]);
            }else if(gap > k){
                quickSortTopKMax(a,mid + 1,high,k);
            }else {
                quickSortTopKMax(a,low,mid -1,k - gap);
            }
        }
    }

    private static void quickSortTopKMin(int[] a, int low ,int high ,int k) {
        if (low<high) {
            int mid = partition(a,low,high);
            int gap = mid - 1;
            if(gap == k) {
                System.out.println(a[mid - 1]);
            }else if(gap > k){
                quickSortTopKMin(a,low,mid -1,k);
            } else {
                quickSortTopKMin(a,mid + 1,high,k - gap);
            }
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = partition(a,low,high);
            quickSort(a,0,mid - 1);
            quickSort(a,mid + 1,high);
        }
    }
    private static int partition(int[] a,int low,int high){
        int key = a[low];
        while (low < high) {
            while (low < high && a[high] >= key) high--;
            swap(a,low,high);
            while (low < high && a[low] <= key) low++;
            swap(a,low,high);
        }
        return low;
    }
    private static void swap(int[] a, int i ,int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
