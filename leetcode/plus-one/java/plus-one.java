class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> numbers = new ArrayList<>();
        int length = digits.length;

        boolean add = true;
        for (int index = length - 1; index >= 0; index--) {
            int digit = digits[index];

            if (add) {
                digit++;
            }

            if (digit > 9) {
                add = true;
                digit = 0;
            } else {
                add = false;
            }

            numbers.add(digit);
        }

        if (add) {
            numbers.add(1);
        }

        Collections.reverse(numbers);

        return numbers.stream().mapToInt(i -> i).toArray();
    }
}