import java.util.*;

class Solution {
    private int[][] map;
    private int[][] operations = {{1, 0}, {0, 1}, {-1, -1}};
    
    public int[] solution(int n) {
        map = new int[n][n];
        
        int x = 0;
        int y = 0;
        int number = 1;
        int operationIndex = 0;
        
        for (int time = n; time > 0; time--) {
            for (int t = 0; t < time - 1; t++) {
                map[x][y] = number++;
                x += operations[operationIndex][0];
                y += operations[operationIndex][1];
            }
            map[x][y] = number++;
            
            operationIndex = computeOperationIndex(operationIndex);
            x += operations[operationIndex][0];
            y += operations[operationIndex][1];
        }
        
        return makeAnswer();
    }
    
    private int computeOperationIndex(int operationIndex) {
        if ((operationIndex + 1) % 3 == 0) {
            return 0;
        }
        return operationIndex + 1;
    }
    
    private int[] makeAnswer() {
        List<Integer> answer = new ArrayList<>();
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                if (map[x][y] != 0) {
                    answer.add(map[x][y]);
                }
            }
        }
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}