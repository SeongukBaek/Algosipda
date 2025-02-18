class Solution {
    private final int MAX = 9;

    public String compressedString(String word) {
        char beforeChar = word.charAt(0);
        int count = 1;

        StringBuilder result = new StringBuilder();
        for (int index = 1; index < word.length(); index++) {
            char currentChar = word.charAt(index);

            if (beforeChar == currentChar && count < 9) {
                count++;
            } else {
                result.append(count);
                result.append(beforeChar);

                beforeChar = currentChar;
                count = 1;
            }
        }

        result.append(count);
        result.append(beforeChar);

        return result.toString();
    }
}