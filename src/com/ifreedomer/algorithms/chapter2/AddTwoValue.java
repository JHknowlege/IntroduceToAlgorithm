package com.ifreedomer.algorithms.chapter2;

public class AddTwoValue {
    int[] add(int a, int b) {
        int sum = a + b;
        int size = 0;
        while (sum != 0) {
            sum = sum / 2;
            size++;
        }
        int[] arr = new int[size];
        sum = a + b;
        int index = 0;
        while (sum != 0) {
            arr[index] = sum % 2;
            sum = sum / 2;
            index++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new AddTwoValue().add(1, 2);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }
}
