class Solution {
    private final int[] charCount = new int[3];

    public int numberOfSubstrings(String s) {
        int length = s.length();
        int count = 0;

        int start = 0;
        int end = 1;

        increaseCount(s.charAt(start));
        
        while (start < length - 2) {
            while (end < length && !isAllIn()) {
                increaseCount(s.charAt(end));
                end++;
            }
            if (isAllIn()) {
                count += (length - (end - 1));
            }

            decreaseCount(s.charAt(start));
            start++;
        }

        return count;
    }

    private void increaseCount(char value) {
        charCount[getIndexByChar(value)]++;
    }

    private void decreaseCount(char value) {
        charCount[getIndexByChar(value)]--;
    }

    private int getIndexByChar(char value) {
        return value - '0' - 49;
    }

    private boolean isAllIn() {
        for (int count : charCount) {
            if (count == 0) {
                return false;
            }
        }
        return true;
    }
}