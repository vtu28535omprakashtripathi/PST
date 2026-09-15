class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int sum = 0;

                int startRow = Math.max(0, i - K);
                int endRow = Math.min(rows - 1, i + K);

                int startCol = Math.max(0, j - K);
                int endCol = Math.min(cols - 1, j + K);

                for (int r = startRow; r <= endRow; r++) {
                    for (int c = startCol; c <= endCol; c++) {
                        sum += mat[r][c];
                    }
                }

                result[i][j] = sum;
            }
        }

        return result;
    }
}
