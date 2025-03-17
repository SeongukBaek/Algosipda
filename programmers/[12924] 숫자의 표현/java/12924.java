class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int number = 1; number <= n; number++) {
            if (isPossible(n, number)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isPossible(int n, int start) {
        int sum = 0;
        
        for (int current = start; current <= n; current++) {
            sum += current;
            
            if (sum == n) {
                return true;
            }
            if (sum > n) {
                return false;
            }
        }
        return false;
    }
}