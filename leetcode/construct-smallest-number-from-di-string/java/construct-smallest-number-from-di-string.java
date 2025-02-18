class Solution {
    private final char I = 'I';
    private final char D = 'D';
    private final int RADIX = 10;

    public String smallestNumber(String pattern) {
        int number = 1;
        int length = pattern.length();
        char[] result = new char[length + 1];

        for (int index = 0; index < length; index++) {
            if (pattern.charAt(index) == I) {
                result[index] = Character.forDigit(number++, RADIX);
            } else if (pattern.charAt(index) == D) {
                while (index < length && pattern.charAt(index) == D) {
                    index++;
                }

                result[index] = Character.forDigit(number++, RADIX);
                int nextIndex = index;
                index--;

                while (index >= 0 && pattern.charAt(index) == D) {
                    result[index] = Character.forDigit(number++, RADIX);
                    index--;
                }
                index = nextIndex;
            }
        }

        if (result[length] == 0) {
            result[length] = Character.forDigit(number, RADIX);
        }

        return String.valueOf(result);
    }
}