class Solution {
    public int findClosest(int x, int y, int z) {
        int oneToThree = Math.abs(x - z);
        int twoToThree = Math.abs(y - z);

        return oneToThree == twoToThree ? 0 : (oneToThree < twoToThree) ? 1 : 2;
    }
}