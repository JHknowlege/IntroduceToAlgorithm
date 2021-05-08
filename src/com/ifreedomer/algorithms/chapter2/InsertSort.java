package com.ifreedomer.algorithms.chapter2;

public class InsertSort {
    //升序排列
    public void insertSortIncrease(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


    //升序递归
    public void insertSortRecursive(int[] arr) {
        insertSortRecursivePart(arr, 0, arr.length);
    }

    public void insertSortRecursivePart(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        int key = arr[L];
        int j = L - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
        insertSortRecursivePart(arr, L + 1, R);
    }

    //降序排列
    public void insertSortDecrease(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            // 4 3 2 5
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 6, 7, 5};
        new InsertSort().insertSortIncrease(arr);
        System.out.println("increase");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }


        System.out.println("\ndecrease");
        new InsertSort().insertSortDecrease(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }


        System.out.println("\nincrease Recursive");
        new InsertSort().insertSortRecursive(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }


    }

}
