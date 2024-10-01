// class Solution {
//     public boolean checkValid(int[][] matrix) {
//         int n = matrix.length;

//         for (int x = 0; x < n; x++) {
//             boolean[] isDuplicated = new boolean[n + 1];

//             for (int y = 0; y < n; y++) {
//                 if (isDuplicated[matrix[x][y]]) {
//                     return false;
//                 }
//                 isDuplicated[matrix[x][y]] = true;
//             }
//         }

//         for (int x = 0; x < n; x++) {
//             boolean[] isDuplicated = new boolean[n + 1];

//             for (int y = 0; y < n; y++) {
//                 if (isDuplicated[matrix[y][x]]) {
//                     return false;
//                 }
//                 isDuplicated[matrix[y][x]] = true;
//             }
//         }

//         return true;
//     }
// }

class Solution {
    private boolean checkRowCol(int k, int[][] matrix) {
        boolean[] row = new boolean[matrix.length+1];
        boolean[] col = new boolean[matrix.length+1];
        for (int i=0; i < matrix.length; i++) {
            if (row[matrix[k][i]]) {
                return false;
            }
            row[matrix[k][i]] = true;
            
            if (col[matrix[i][k]]) {
                return false;
            }
            col[matrix[i][k]] = true;
        }
        return true;
    }
    public boolean checkValid(int[][] matrix) {
        for (int i=0; i < matrix.length; i++) {
            if (!checkRowCol(i, matrix)) {
                return false;
            }
        }
        return true;
    }
}