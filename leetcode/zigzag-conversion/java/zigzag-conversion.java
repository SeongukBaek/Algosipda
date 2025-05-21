class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        char[][] map = new char[numRows][s.length()];

        int x = 0;
        int y = 0;
        boolean up = false;
        for (int index = 0; index < s.length(); index++) {
            char current = s.charAt(index);

            map[x][y] = current;

            if (!up) {
                x++;

                if (x == numRows) {
                    x--;
                    up = true;
                }
            }

            if (up) {
                x--;
                y++;

                if (x == 0) {
                    up = false;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (x = 0; x < numRows; x++) {
            for (y = 0; y < s.length(); y++) {
                if (map[x][y] != 0) {
                    result.append(map[x][y]);
                }
            }
        }

        return result.toString();
    }
}