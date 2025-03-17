import java.util.*;

class Solution {
    private final Queue<Integer> sortedWorks = new PriorityQueue<>(Collections.reverseOrder());
    public long solution(int n, int[] works) {
        for (int work : works) {
            sortedWorks.add(work);
        }
        
        while (n > 0 && !sortedWorks.isEmpty()) {
            int work = sortedWorks.poll() - 1;
            if (work > 0) {
                sortedWorks.add(work);
            }
            
            n--;
        }
        
        long answer = 0;
        
        while (!sortedWorks.isEmpty()) {
            answer += Math.pow(sortedWorks.poll(), 2);
        }
        
        return answer;
    }
}