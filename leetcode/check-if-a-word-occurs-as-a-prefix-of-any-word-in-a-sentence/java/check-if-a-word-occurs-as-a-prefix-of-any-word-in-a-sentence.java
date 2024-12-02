class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] splitedSentence = sentence.split(" ");
        int searchWordSize = searchWord.length();

        int index = 0;
        for (String word : splitedSentence) {
            index++;
            if (word.length() < searchWordSize) {
                continue;
            }

            boolean isPrefix = true;
            for (int current = 0; current < searchWordSize; current++) {
                if (word.charAt(current) != searchWord.charAt(current)) {
                    isPrefix = false;
                    break;
                }
            }

            if (isPrefix) {
                return index;
            }
        }

        return -1;
    }
}