package com.ifreedomer.algorithms.chapter2;

public class MergeSortProv1 {
    public void mergeTwoArray(int[] arr, int L, int M, int R) {
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

        System.arraycopy(arr, L, leftArr, 0, leftSize);
        System.arraycopy(arr, M, rightArr, 0, rightSize);

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


    //一个数组
    public void mergeOneArray(int[] arr, int L, int R, int rightEnd) {
        int[] tempArr = new int[arr.length];
        int leftEnd = R - 1;
        int temp = L;
        int elementCount = rightEnd - L + 1;
        while (L <= leftEnd && R <= rightEnd) {
            if (arr[L] < arr[R]) {
                tempArr[temp++] = arr[L++];
            } else {
                tempArr[temp++] = arr[R++];
            }
        }

        while (L <= leftEnd) {
            tempArr[temp++] = arr[L++];
        }

        while (R <= rightEnd) {
            tempArr[temp++] = arr[R++];
        }

        //把temparr拷贝回arr
        L = rightEnd - elementCount+1;
        System.arraycopy(tempArr, L, arr, L, elementCount);


    }

    public void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = (L + R) / 2;
        mergeSort(arr, L, M);
        mergeSort(arr, M + 1, R);
        mergeOneArray(arr, L, M + 1, R);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{9, 2, 3, 4, 5, 6, 7, 8};
        MergeSortProv1 mergeSort = new MergeSortProv1();
//        mergeSort.mergeOneArray(arr, 0,arr.length/2+1, arr.length - 1);
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

}
