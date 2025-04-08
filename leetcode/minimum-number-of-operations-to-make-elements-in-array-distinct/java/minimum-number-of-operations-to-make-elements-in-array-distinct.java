class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        int index; 
        for (index = nums.length - 1; index >= 0; index--) {
            if (numSet.contains(nums[index])) {
                break;
            }
            numSet.add(nums[index]);
        }

        int count = (index + 1) / 3;
        if ((index + 1) % 3 != 0) {
            count++;
        }

        return count;
    }
}