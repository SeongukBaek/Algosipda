class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        int[] answer = new int[M * N];

        int index = 0;
        int x = 0;
        int y = 0;
        boolean isUp = true;
        while (true) {
            answer[index++] = mat[x][y];

            if (x == M - 1 && y == N - 1) {
                break;
            }

            if (isUp) {
                if (y == N - 1) {
                    x += 1;
                    isUp = false;
                    continue;
                }
                if (x == 0) {
                    y += 1;
                    isUp = false;
                    continue;
                }

                x -= 1;
                y += 1;
            } else {
                if (x == M - 1) {
                    isUp = true;
                    y += 1;
                    continue;
                }
                if (y == 0) {
                    isUp = true;
                    x += 1;
                    continue;
                }

                x += 1;
                y -= 1;
            }
        }

        return answer;
    }
}