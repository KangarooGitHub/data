package com.tendcloud.es.es_java_api;

import java.util.Arrays;

/**
 * BinSearchTest1
 *
 * @author panxing.fu
 * @create 2019-01-18 9:58
 **/
public class BinSearchTest1 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,5,5,6,7,8,9};
        System.out.println(Arrays.toString(a));
        int index = BinSearchTest1.binSearch(a, 5, 0, a.length - 1);
        System.out.println(index);

    }

    private static int binSearch(int[] a,int i , int low, int high) {
        if(low <= high) {
            int mid = low + (high - low)/2;
            if(a[mid] == i) {
                //查找最后一个等于要查找的值的索引，去掉这里的判断，就是查找第一个等于要查找的值的索引
                if(mid == high || a[mid + 1] != i){
                    return mid;
                } else {
                    return binSearch(a,i,mid + 1,high);
                }
            } else if (a[mid] > i){
                return binSearch(a,i,low,mid - 1);
            } else if(a[mid] < i) {
                return binSearch(a,i,mid + 1,high);
            }
        }
        return -9999;
    }
}
