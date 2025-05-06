import java.util.*;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> pair = new HashMap<>();

        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];

            String key;
            if (a > b) {
                key = String.valueOf(b) + String.valueOf(a);
            } else {
                key = String.valueOf(a) + String.valueOf(b);
            }

            if (pair.containsKey(key)) {
                pair.put(key, pair.get(key) + 1);
            } else {
                pair.put(key, 0);
            }
        }

        int answer = 0;
        for (String key : pair.keySet()) {
            answer += getValue(pair.get(key));
        }
        return answer;
    }

    private int getValue(int value) {
        int sum = 0;
        for (int n = value; n > 0; n--) {
            sum += n;
        }
        return sum;
    }
}