class Solution {
    private List<int[]> points;
    private boolean isValid;

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1[0] == p2[0] && p1[1] == p2[1]) {
            return false;
        }
        if (p2[0] == p3[0] && p2[1] == p3[1]) {
            return false;
        }
        if (p3[0] == p4[0] && p3[1] == p4[1]) {
            return false;
        }
        if (p1[0] == p4[0] && p1[1] == p4[1]) {
            return false;
        }

        points = List.of(p1, p2, p3, p4);

        permutation(new int[] {0, 1, 2, 3}, 0, 4, 4);

        return isValid;
    }

    private void permutation(int[] orders, int depth, int n, int r) {
        if (isValid) {
            for (int index = 0; index < 4; index++) {
                System.out.print(orders[index]);
            }
            return;
        }

        if (depth == r) {
            isValid = checkValidSquare(orders);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(orders, depth, i);
            permutation(orders, depth + 1, n, r);
            swap(orders, depth, i);
        }
    }

    private void swap(int[] orders, int depth, int i) {
        int temp = orders[depth];
        orders[depth] = orders[i];
        orders[i] = temp;
    }

    private boolean checkValidSquare(int[] orders) {
        int[] p1 = points.get(orders[0]);
        int[] p2 = points.get(orders[1]);
        int[] p3 = points.get(orders[2]);
        int[] p4 = points.get(orders[3]);

        double length = getDistance(p2, p1);
        if (getDistance(p3, p2) != length) {
            return false;
        }
        if (getDistance(p3, p4) != length) {
            return false;
        }
        if (getDistance(p4, p1) != length) {
            return false;
        }

        double diagonalLength = getDistance(p3, p1);
        if (getDistance(p1, p2) + getDistance(p2, p3) != diagonalLength) {
            return false;
        }
        if (getDistance(p3, p4) + getDistance(p4, p1) != diagonalLength) {
            return false;
        }

        return true;
    }

    private double getDistance(int[] p1, int[] p2) {
        return Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
    }
}