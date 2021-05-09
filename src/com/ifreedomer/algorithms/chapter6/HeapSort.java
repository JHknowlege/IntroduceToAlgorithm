package com.ifreedomer.algorithms.chapter6;

import java.util.ArrayList;
/**
 * https://www.bilibili.com/video/BV1Eb41147dK?from=search&seid=10611145683300007052
 */
public class HeapSort {

    public static class HeapSortRecursive{
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
            for (int i = arr.length-1; i >=0 ; )  {
                swap(arr,0,i);
                i--;
                heapify(arr,i,0);
            }
        }

    }


    public static class HeapSortSimple{


        public void swap(int[] arr,int i,int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


        //尾递归写成迭代的方式
        public void heapify(int[] arr,int len,int heapIndex){
            while (heapIndex<=len){
                int L = heapIndex*2+1;
                int R = heapIndex*2+2;
                int maxIndex = heapIndex;
                if(R<=len&&arr[R]>arr[maxIndex]){
                    maxIndex = R;
                }
                if (L<=len&&arr[L]>arr[maxIndex]){
                    maxIndex = L;
                }
                if (maxIndex!=heapIndex){
                    swap(arr,maxIndex,heapIndex);
                    //进入到需要heapify的子节点
                    heapIndex = maxIndex;
                }else{
                    break;
                }

            }

        }



        void buildHeap(int[] arr){
            int last = arr.length-1;
            int lastParent = (last-1)/2;
            for (int i = lastParent; i >=0 ; i--) {
                heapify(arr,last,i);
            }
            System.out.println("\nbuildHeap");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+"\t");
            }
        }


        public void sort(int[] arr){
            buildHeap(arr);



            //最后一个位置与root交换，并且把root heapify
            for (int i = arr.length-1; i >=0 ;)  {
                swap(arr,0,i);
                i--;
                heapify(arr,i,0);
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,10,3,5};
        new HeapSortSimple().sort(arr);
        System.out.println("\nsort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }



}
