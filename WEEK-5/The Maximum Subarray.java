import java.io.*;
import java.util.*;

public class Solution {

    public static int[] maxSubarray(int[] arr) {

        int maxSubarray = arr[0];
        int currentSum = arr[0];

        int maxSubsequence = arr[0];
        int positiveSum = 0;

        boolean hasPositive = false;

        for (int i = 1; i < arr.length; i++) {

            // Kadane's Algorithm for maximum subarray
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSubarray = Math.max(maxSubarray, currentSum);

            // Maximum subsequence
            if (arr[i] > 0) {
                positiveSum += arr[i];
                hasPositive = true;
            }

            if (arr[i] > maxSubsequence) {
                maxSubsequence = arr[i];
            }
        }

        // Include first element if it is positive
        if (arr[0] > 0) {
            positiveSum += arr[0];
            hasPositive = true;
        }

        if (hasPositive) {
            maxSubsequence = positiveSum;
        }

        return new int[] { maxSubarray, maxSubsequence };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] result = maxSubarray(arr);

            System.out.println(result[0] + " " + result[1]);
        }

        sc.close();
    }
}
