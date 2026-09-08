```java
import java.io.*;
import java.util.*;

public class Solution {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();

        int leftDiagonal = 0;
        int rightDiagonal = 0;

        for (int i = 0; i < n; i++) {
            // Top-left to bottom-right
            leftDiagonal += arr.get(i).get(i);

            // Top-right to bottom-left
            rightDiagonal += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(leftDiagonal - rightDiagonal);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            String[] values = bufferedReader.readLine().trim().split(" ");

            List<Integer> row = new ArrayList<Integer>();

            for (int j = 0; j < n; j++) {
                row.add(Integer.parseInt(values[j]));
            }

            arr.add(row);
        }

        int result = diagonalDifference(arr);

        System.out.println(result);

        bufferedReader.close();
    }
}
```
