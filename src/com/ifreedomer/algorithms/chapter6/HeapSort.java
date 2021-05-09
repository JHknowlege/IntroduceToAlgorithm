package com.ifreedomer.algorithms.chapter6;

import java.util.ArrayList;
/**
 * https://www.bilibili.com/video/BV1Eb41147dK?from=search&seid=10611145683300007052
 */
public class HeapSort {

    public void heapSort(int[] arr){

    }

    /**
     *
     *
     *             4
     *      10           5
     *  1     2       3
     *
     *
     *
     */

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void heapify(int[] arr,int len,int heapIndex){
        if (len <= heapIndex){
            return;
        }
        int maxIndex = heapIndex;
        int L = heapIndex*2+1;
        int R = heapIndex*2+2;
        if (len>L&&arr[L]>arr[maxIndex]){
            maxIndex = L;
        }
        if (len>R&&arr[R]>arr[maxIndex]){
            maxIndex = R;
        }
        if (maxIndex!=heapIndex){
            swap(arr,maxIndex,heapIndex);
            //此时的maxIndex不是L就是R,往下缩小范围
            heapify(arr,len,maxIndex);
        }
    }


    void buildHeap(int[] arr){
        int last = arr.length-1;
        int lastParent = (last-1)/2;
        for (int i = lastParent; i >=0 ; i--) {
            heapify(arr,last,i);
        }
    }


    public void sort(int[] arr){
        buildHeap(arr);
        //最后一个位置与root交换，并且把root heapify
        for (int i = arr.length-1; i >=0 ; i--)  {
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,10,3,5};
        //{10,4,3,5}
        new HeapSort().sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }



}
