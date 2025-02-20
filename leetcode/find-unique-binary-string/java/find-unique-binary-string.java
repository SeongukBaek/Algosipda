class Solution {
    private final boolean[] isIn = new boolean[65537];
    private int length;

    public String findDifferentBinaryString(String[] nums) {
        length = nums.length;

        for (String num : nums) {
            isIn[getIntFromBinary(num)] = true;
        }

        int num;
        for (num = 0; num < 65537; num++) {
            if (!isIn[num]) {
                break;
            }
        }

        return String.format("%"+ length + "s", Integer.toBinaryString(num)).replace(" ", "0");
    }

    private int getIntFromBinary(String num) {
        int sum = 0;

        for (int index = 0; index < length; index++) {
            double c = Math.pow(2, index);
            sum += (Character.getNumericValue(num.charAt(length - 1 - index)) * c);
        }

        return sum;
    }
}