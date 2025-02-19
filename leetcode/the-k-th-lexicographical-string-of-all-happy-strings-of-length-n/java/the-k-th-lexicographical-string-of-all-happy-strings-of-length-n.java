class Solution {
    private char[] letters = {'a', 'b', 'c'};
    private int count = 0;
    private int n;
    private int k;
    private String answer = "";

    public String getHappyString(int n, int k) {
        this.n = n;
        this.k = k;

        makeHappyString(new StringBuilder(), 0);

        return answer;
    }

    private void makeHappyString(StringBuilder result, int index) {
        if (index == n) {
            count++;

            if (count == k) {
                answer = result.toString();
            }
            return;
        }

        if (answer != "") {
            return;
        }

        for (int letterIndex = 0; letterIndex < 3; letterIndex++) {
            char current = letters[letterIndex];
            if (index < n && (index == 0 || result.charAt(index - 1) != current)) {
                result.append(current);
                makeHappyString(result, index + 1);
                result.deleteCharAt(index);
            }
        }
    }
}