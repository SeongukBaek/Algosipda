class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int oneSize = str1.length();
        int twoSize = str2.length();
        int one = 0;
        int two = 0;

        while (one < oneSize && two < twoSize) {
            char oneChar = str1.charAt(one);
            char twoChar = str2.charAt(two);
            if (oneChar == twoChar || nextChar(oneChar) == twoChar) {
                one++;
                two++;
                
                if (two == twoSize) {
                    return true;
                }
                continue;
            }

            one++;
        }

        return false;
    }

    private char nextChar(char current) {
        if (current == 'z') {
            return 'a';
        }
        return (char) (current + 1);
    }
}