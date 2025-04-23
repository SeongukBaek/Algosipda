import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> numberMap = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            List<Integer> indexList = numberMap.getOrDefault(num, new ArrayList<>());
            indexList.add(index);
            numberMap.put(num, indexList);
        }

        int[] answer = new int[2];
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            int other = target - num;

            if (!numberMap.containsKey(other)) {
                continue;
            }

            List<Integer> indexes = numberMap.get(other);

            if (num == other && indexes.size() == 1) {
                continue;
            }

            if (num == other) {
                answer[0] = indexes.get(0);
                answer[1] = indexes.get(1);
            } else {
                answer[0] = index;
                answer[1] = indexes.get(0);
            }
            break;
        }
        return answer;
    }
}