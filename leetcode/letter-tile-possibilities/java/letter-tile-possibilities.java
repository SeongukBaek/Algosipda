import java.util.*;

class Solution {
    private final Set<String> sequences = new HashSet<>();
    private int length;
    private String tiles;

    public int numTilePossibilities(String tiles) {
        this.tiles = tiles;
        this.length = tiles.length();

        for (int count = 1; count <= length; count++) {
            makeSequences(new StringBuilder(), count, new boolean[length]);
        }

        return sequences.size();
    }

    private void makeSequences(StringBuilder candidate, int count, boolean[] isIn) {
        if (candidate.length() == count) {
            String result = candidate.toString();
            sequences.add(result);
            return;
        }

        for (int index = 0; index < length; index++) {
            if (isIn[index]) {
                continue;
            }

            isIn[index] = true;
            candidate.append(tiles.charAt(index));
            makeSequences(candidate, count, isIn);
            candidate.deleteCharAt(candidate.length() - 1);
            isIn[index] = false;
        }
    }
}