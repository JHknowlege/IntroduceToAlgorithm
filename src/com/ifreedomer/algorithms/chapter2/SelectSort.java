package com.ifreedomer.algorithms.chapter2;

public class SelectSort {
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = findMinPosition(i, arr.length-1, arr);
            if (minPos == -1) {
                continue;
            }
            //交换值
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    public int findMinPosition(int start, int end, int[] arr) {
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for (int i = start; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                pos = i;
            }
        }
        return pos;
    }

    public void selectSortRecursive(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }

        int minPos = findMinPosition(start, arr.length, arr);
        //交换值
        int temp = arr[start];
        arr[start] = arr[minPos];
        arr[minPos] = temp;
        selectSortRecursive(arr, start + 1, end);

    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 1, 0};
        System.out.println("selectSortRecursive");
        new SelectSort().selectSortRecursive(arr,0,arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println("\nselectSort");
        new SelectSort().selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
