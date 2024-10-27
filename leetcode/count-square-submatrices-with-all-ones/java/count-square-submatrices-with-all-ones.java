class Solution {
    private int[][] matrix;
    private int m;
    private int n;

    public int countSquares(int[][] matrix) {
        this.matrix = matrix;
        int sum = 0;
        m = matrix.length;
        n = matrix[0].length;

        int min = Math.min(m, n);

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                for (int size = 1; size <= min && x + size <= m && y + size <= n; size++) {
                    if (isSquare(x, y, size)) {
                        sum++;
                    }
                }
            }
        }

        return sum;
    }

    private boolean isSquare(int startX, int startY, int size) {
        for (int x = startX; x < startX + size; x++) {
            for (int y = startY; y < startY + size; y++) {
                if (matrix[x][y] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}