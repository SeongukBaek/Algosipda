class Solution {
    private int[][] grid;
    private int[][] moves;
    private int m;
    private int n;
    private int maxMove = 0;
    private int[][] directions = {{-1, 1}, {0, 1}, {1, 1}};

    public int maxMoves(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.moves = new int[m][n];

        for (int x = 0; x < m; x++) {
            move(x, 0, 0);
        }

        return maxMove;
    }

    public void move(int x, int y, int move) {
        for (int[] direction : directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            int nextMove = move + 1;

            if (!isIn(nextX, nextY) || grid[nextX][nextY] <= grid[x][y] || moves[nextX][nextY] >= nextMove) {
                continue;
            }

            moves[nextX][nextY] = nextMove;
            maxMove = Math.max(maxMove, moves[nextX][nextY]);
            move(nextX, nextY, moves[nextX][nextY]);
        }
    }

    private boolean isIn(int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }
}