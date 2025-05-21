class Solution {
    public String triangleType(int[] nums) {
        if (!canCreateTriangle(nums)) {
            return "none";
        }

        int equalCount = getEqualCount(nums);

        if (equalCount == 3) {
            return "equilateral";
        } else if (equalCount == 2) {
            return "isosceles";
        }
        return "scalene";
    }

    private boolean canCreateTriangle(int[] nums) {
        return nums[0] + nums[1] > nums[2] && nums[0] + nums[2] > nums[1] && nums[1] + nums[2] > nums[0];
    }

    private int getEqualCount(int[] nums) {
        if (nums[0] == nums[1] && nums[0] == nums[2]) {
            return 3;
        }
        if (nums[1] == nums[2] || nums[0] == nums[1] || nums[0] == nums[2]) {
            return 2;
        }
        return 1;
    }
}