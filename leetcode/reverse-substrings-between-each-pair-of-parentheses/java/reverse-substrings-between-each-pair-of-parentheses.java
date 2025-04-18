class Solution {
    private StringBuilder result = new StringBuilder();
    private char open = '(';
    private char close = ')';

    public String reverseParentheses(String s) {
        for (int index = 0; index < s.length(); index++) {
            char current = s.charAt(index);

            if (current == close) {
                int start = findLastOpen();
                int end = result.length();

                if (end - 1 - start > 1) {
                    String reversed = new StringBuilder(result.substring(start + 1, end)).reverse().toString();
                    result.replace(start + 1, end, reversed);
                }
                result.deleteCharAt(start);
            } else {
                result.append(current);
            }
        }

        return result.toString();
    }

    private int findLastOpen() {
        int index = result.length() - 1;
        while (result.charAt(index) != '(') {
            index--;
        }
        return index;
    }
}