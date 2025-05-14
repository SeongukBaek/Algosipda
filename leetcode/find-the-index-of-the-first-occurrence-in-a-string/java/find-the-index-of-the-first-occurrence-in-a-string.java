class Solution {
    public int strStr(String haystack, String needle) {
        char first = needle.charAt(0);
        int hLength = haystack.length();
        int nLength = needle.length();

        for (int h = 0; h < hLength; h++) {
            if (first == haystack.charAt(h) && h + nLength <= hLength) {
                if (needle.equals(haystack.substring(h, h + nLength))) {
                    return h;
                }
            }
        }
        return -1;
    }
}