class Solution {
    private Queue<int[]> zeros = new LinkedList<>();

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    zeros.add(new int[] {row, col});
                }
            }
        }

        while (!zeros.isEmpty()) {
            int[] currentZero = zeros.poll();

            for (int row = 0; row < rows; row++) {
                matrix[row][currentZero[1]] = 0;
            }
            for (int col = 0; col < cols; col++) {
                matrix[currentZero[0]][col] = 0;
            }
        }
    }
}