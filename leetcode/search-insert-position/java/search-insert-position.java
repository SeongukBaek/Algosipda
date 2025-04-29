class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int mid = 0;
        int answer = -1;
        while (start <= end) {
            mid = (start + end) / 2;

            if (nums[mid] == target) {
                answer = mid;
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (answer == -1) {
            if (nums[mid] < target) {
                return mid + 1;
            }
            return mid;
        }
        return answer;
    }
}