import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return convertNumber(x, y, n);
    }
    
    private int convertNumber(int x, int y, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[1000001];
        
        queue.add(new int[] {x, 0});
        int count = -1;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNumber = current[0];
            int currentCount = current[1];
            
            if (currentNumber == y) {
                count = currentCount;
                break;
            }
            
            int next = currentNumber + n;
            if (next <= y && !isVisited[next]) {
                isVisited[next] = true;
                queue.add(new int[] {next, currentCount + 1});
            }

            next = currentNumber * 2;
            if (next <= y && !isVisited[next]) {
                isVisited[next] = true;
                queue.add(new int[] {next, currentCount + 1});
            }

            next = currentNumber * 3;
            if (next <= y && !isVisited[next]) {
                isVisited[next] = true;
                queue.add(new int[] {next, currentCount + 1});
            }
        }
        
        return count;
    }
}