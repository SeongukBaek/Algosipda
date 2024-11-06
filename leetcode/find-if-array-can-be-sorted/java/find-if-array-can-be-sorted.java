import java.util.*;

class Solution {
    private int[] nums;
    private int size = 0;
    private final Map<Integer, Integer> setBits = new HashMap<>();

    public boolean canSortArray(int[] nums) {
        // 2진 표현 시, 1의 개수가 동일하고, 인접한 숫자들끼리만 스왑 가능
        this.nums = nums;
        this.size = nums.length;

        getSetBits();
        bubbleSort();

        for (int index = 0; index < size - 1; index++) {
            if (nums[index] > nums[index + 1]) {
                return false;
            }
        }
        return true;
    }

    private void getSetBits() {
        for (int num : nums) {
            setBits.put(num, getOne(Integer.toBinaryString(num)));
        }
    }

    private int getOne(String binary) {
        int one = 0;
        for (int index = 0; index < binary.length(); index++) {
            if (binary.charAt(index) == '1') {
                one++;
            }
        }
        return one;
    }

    private void bubbleSort() {
        for (int round = 1; round < size; round++) {
            for (int index = 0; index < size - round; index++) {
                if (nums[index] > nums[index + 1] && setBits.get(nums[index]) == setBits.get(nums[index + 1])) {
                    swap(index);
                }
            }
        }
    }

    private void swap(int index) {
        int temp = nums[index];
        nums[index] = nums[index + 1];
        nums[index + 1] = temp;
    }
}