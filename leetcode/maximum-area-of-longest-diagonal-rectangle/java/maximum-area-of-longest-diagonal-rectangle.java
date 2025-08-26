class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double max = 0.0;
        int maxArea = 0;

        for (int[] dimension: dimensions) {
            double diagonal = Math.sqrt(dimension[0] * dimension[0] + dimension[1] * dimension[1]);
            int area = dimension[0] * dimension[1];

            if (max < diagonal) {
                max = diagonal;
                maxArea = area;
            } else if (max == diagonal) {
                if (maxArea < area) {
                    max = diagonal;
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }
}