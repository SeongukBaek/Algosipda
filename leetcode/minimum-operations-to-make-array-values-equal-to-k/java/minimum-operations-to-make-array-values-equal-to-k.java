import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        // k보다 작은 게 있으면 -1
        // k보다 큰 수 개수 리턴
        int count = 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : numSet) {
            if (num < k) {
                return -1;
            } else if (num > k) {
                count++;
            }
        }

        return count;
    }
}