package com.ifreedomer.algorithms.chapter2;

public class MergeSort {
    public void merge(int[] arr, int L, int M, int R) {
        //1 2 3 4 5
        //mid = (5-1)/2 = 2
        //L=0;
        //R=5-1=4
        //左边的size
        int leftSize = M - L;
        //右边的size (4-2)+1=3
        int rightSize = R - M + 1;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        //左边数组赋值,闭区间
        for (int i = L; i < M; i++) {
            leftArr[i - L] = arr[i];
        }

        //右边数组赋值，这里用等号是因为我们传进来的是length-1,可以直接使用最后一个元素
        for (int i = M; i <= R; i++) {
            rightArr[i - M] = arr[i];
        }

        //比较左边和右边，并插入
        int leftCur = 0;
        int rightCur = 0;
        int originalCur = L;
        while (leftCur < leftSize && rightCur < rightSize) {
            //左右对比,左边小,放入原始数组
            if (leftArr[leftCur] < rightArr[rightCur]) {
                arr[originalCur++] = leftArr[leftCur++];
            } else {
            //左右对比,左边小,放入原始数组
                arr[originalCur++] = rightArr[rightCur++];
            }
        }

        //左边没有放完的元素
        while (leftCur < leftSize) {
            arr[originalCur++] = leftArr[leftCur++];
        }

        //右边没有放完的元素
        while (rightCur < rightSize) {
            arr[originalCur++] = rightArr[rightCur++];
        }

    }

    public void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = (L + R) / 2;
        mergeSort(arr, L, M);
        mergeSort(arr, M + 1, R);
        merge(arr, L, M + 1, R);
    }




    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 4, 7, 6, 5, 8};
        MergeSort mergeSort = new MergeSort();
        int L = 0;
        int R = arr.length - 1;
        mergeSort.mergeSort(arr, L, R);
        System.out.println("\nresult");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

}
