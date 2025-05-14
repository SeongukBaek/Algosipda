class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int index = 1; index < length - 1; index++) {
            dp[index] = Math.max(nums[index] + index, dp[index - 1]);

            if (dp[index] == index) {
                return false;
            }
        }

        return true;
    }
}