class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (String s1, String s2) -> s1.length() - s2.length());
        
        String target = strs[0];
        StringBuilder result = new StringBuilder("");
        for (int index = 0; index < target.length(); index++) {
            char current = target.charAt(index);

            boolean isCorrect = true;
            for (int other = 1; other < strs.length; other++) {
                if (current != strs[other].charAt(index)) {
                    isCorrect = false;
                    break;
                }
            }

            if (isCorrect) {
                result.append(current);
            } else {
                break;
            }
        }

        return result.toString();
    }
}