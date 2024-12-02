class Solution {
    public int maximumCount(int[] nums) {
        int size = nums.length;
        int zero = 0;
        int index = 0;

        while (nums[index] <= 0) {
            if (nums[index] == 0) {
                zero++;
            }

            if (++index == size) {
                break;
            }
        }

        int negCount = index - zero;
        int posCount = size - negCount - zero;
        return Math.max(negCount, posCount);
    }
}