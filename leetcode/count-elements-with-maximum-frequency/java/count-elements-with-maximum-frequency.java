class Solution {
    private int max;
    private int[] frequency = new int[101];

    public int maxFrequencyElements(int[] nums) {
        for (int num : nums) {
            frequency[num]++;
            if (max < frequency[num]) {
                max = frequency[num];
            }
        }

        int sum = 0;
        for (int f : frequency) {
            if (f == max) {
                sum += f;
            }
        }
        return sum;
    }
}