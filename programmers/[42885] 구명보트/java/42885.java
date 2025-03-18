import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        boolean[] isExited = new boolean[people.length];
        Arrays.sort(people);
        
        int answer = 0;
        for (int index = 0; index < people.length; index++) {
            int current = people[index];
            
            if (isExited[index]) {
                continue;
            }
            
            isExited[index] = true;
            answer++;
            
            int pairIndex = Arrays.binarySearch(people, limit - current + 1);
            if (pairIndex < 0) {
                pairIndex = (pairIndex + 1) * -1;
            }            
            if (pairIndex-- <= index) {
                continue;
            }
            
            while (pairIndex > index) {
                if (!isExited[pairIndex] && limit - current >= people[pairIndex]) {
                    isExited[pairIndex] = true;
                    break;
                }
                pairIndex--;
            }
        }
        
        return answer;
    }
}