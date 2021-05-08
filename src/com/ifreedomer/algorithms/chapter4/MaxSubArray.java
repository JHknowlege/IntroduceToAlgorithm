package com.ifreedomer.algorithms.chapter4;

public class MaxSubArray {
    //动态规划(前缀和)
    public static class MaxSubArrayDP {
        public int findMaxSubArray(int[] arr) {
            int ans = arr[0];
            for (int i = 1; i < arr.length; i++) {
                //如果之前的和为负数，舍弃变为0
                int cur = Math.max(arr[i - 1], 0);
                //将之前的和加上当前的数字
                arr[i] = arr[i] + cur;
                ans = Math.max(ans, arr[i]);
            }
            return ans;
        }
    }

    //暴力解法
    public static class MaxSubArrayForce {
        public int findMaxSubArray(int[] arr) {
            int ans = arr[0];
            for (int i = 0; i < arr.length; i++) {
                int curMax = 0;
                for (int j = i; j < arr.length; j++) {
                    //得到任意组合
                    curMax = curMax + arr[j];
                    //循环找最大值
                    if (curMax > ans) {
                        ans = curMax;
                    }
                }

            }
            return ans;
        }
    }

    //贪心算法
    public static class GreedyAlgorithm {
        public int findMaxSubArray(int[] arr) {
            int max = arr[0];
            int curMax = max;
            for (int i = 0; i < arr.length; i++) {
                if (curMax >= 0) {
                    curMax = curMax + arr[i];
                } else {
                    curMax = arr[i];
                }
                if (curMax > max) {
                    max = curMax;
                }
            }
            return max;
        }
    }


    public static class MaxSubArrayDividerAndConquer {
        public int findMaxSubArray(int[] arr, int L, int R) {
            if (L == R) {
                return arr[L];
            }
            int M = L + (R - L) / 2;
            int leftSum = findMaxSubArray(arr, L, M);
            int rightSum = findMaxSubArray(arr, M + 1, R);
            int crossLAndRSum = crossLAndRSum(arr, L, M, R);
            return Math.max(Math.max(leftSum, rightSum), crossLAndRSum);
        }


        public int crossLAndRSum(int[] arr, int L, int M, int R) {
            int tempMax = 0;
            int leftMax = Integer.MIN_VALUE;
            //从中间开始，往左边延伸
            for (int i = M; i >= L; i--) {
                tempMax += arr[i];
                if (tempMax > leftMax) {
                    leftMax = tempMax;
                }
            }
            //从中间开始，往右边延伸
            int rightMax = Integer.MIN_VALUE;
            tempMax = 0;
            for (int i = M + 1; i <= R; i++) {
                tempMax += arr[i];
                if (tempMax > rightMax) {
                    rightMax = tempMax;
                }
            }
            return leftMax + rightMax;

        }


    }


    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, 4, -5, 1};
        int maxSubArray = new MaxSubArrayDP().findMaxSubArray(arr);
        System.out.println("maxSubArray dp = " + maxSubArray);

        arr = new int[]{-1, -2, -3, 4, -5, 1};
        int maxSubArrayForce = new MaxSubArrayForce().findMaxSubArray(arr);
        System.out.println("maxSubArray force = " + maxSubArrayForce);


         arr = new int[]{-1, -2, -3, 4, -5, 1};
        int maxDividerAndConquer = new MaxSubArrayDividerAndConquer().findMaxSubArray(arr, 0, arr.length - 1);
        System.out.println("maxSubArray force = " + maxDividerAndConquer);

        arr = new int[]{-1, -2, -3, 4, -5, 1};
        int greedyAlgorithm = new GreedyAlgorithm().findMaxSubArray(arr);
        System.out.println("greedyAlgorithm = " + greedyAlgorithm);


    }

}
