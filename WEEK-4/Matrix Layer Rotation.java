import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;

            // Number of elements in this layer
            int perimeter = 2 * (bottom - top + right - left);

            int rotations = r % perimeter;

            for (int k = 0; k < rotations; k++) {
                rotateLayer(matrix, top, left, bottom, right);
            }
        }

        // Print the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);

                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        sc.close();
    }

    // Rotate one layer anti-clockwise by one position
    public static void rotateLayer(int[][] matrix,
                                   int top,
                                   int left,
                                   int bottom,
                                   int right) {

        int temp = matrix[top][left];

        // Top row: move left
        for (int j = left; j < right; j++) {
            matrix[top][j] = matrix[top][j + 1];
        }

        // Right column: move up
        for (int i = top; i < bottom; i++) {
            matrix[i][right] = matrix[i + 1][right];
        }

        // Bottom row: move right
        for (int j = right; j > left; j--) {
            matrix[bottom][j] = matrix[bottom][j - 1];
        }

        // Left column: move down
        for (int i = bottom; i > top; i--) {
            matrix[i][left] = matrix[i - 1][left];
        }

        matrix[top + 1][left] = temp;
    }
}
