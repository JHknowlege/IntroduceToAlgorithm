package com.ifreedomer.algorithms.chapter7;

public class QuickSort {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int median3(int[] arr, int L, int M, int R) {
        if (arr[L] > arr[M]) {
            swap(arr, L, M);
        }

        if (arr[L] > arr[R]) {
            swap(arr, L, R);
        }

        if (arr[M] > arr[R]) {
            swap(arr, M, R);
        }


        swap(arr, M, R - 1);

        return R - 1;
    }


    public void quickSort(int[] arr,int L ,int R){
        if (R-L<=1){
            return;
        }
        int M = L+(R-L)/2;
        int pivot = median3(arr,L,M,R);
        int i = L;
        int j = R-1;
        for (;;){
            while (arr[++i]<arr[pivot]);
            while (arr[--j]>arr[pivot]);
            if (i<j){
                swap(arr,i,j);
            }else{
                break;
            }
        }
        swap(arr,pivot,i);
        quickSort(arr,L,M);
        quickSort(arr,M+1,R);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        testMedian3(quickSort);

        int[] arr = new int[]{3,2,1,5,6,7};
        quickSort.quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }

    private static void testMedian3(QuickSort quickSort) {
        int[] arr = {1, 2, 3};
        int median3 = quickSort.median3(arr, 0,1, 2);
        System.out.println("median3 = "+arr[median3]);
    }
}
