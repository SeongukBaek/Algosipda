import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int m = triangle[n - 1].length;
        
        if (n == 1) {
            return triangle[0][0];    
        }   
        
        int[][] dp = new int[n][m];
        for (int index = 0; index < n; index++) {
            dp[index] = Arrays.copyOf(triangle[index], m);
        }
        
        for (int x = 1; x < n; x++) {
            dp[x][0] += dp[x - 1][0];
            
            for (int y = 1; y < m - 1; y++) {
                dp[x][y] += Math.max(dp[x - 1][y - 1], dp[x - 1][y]);
            }
            
            dp[x][m - 1] += dp[x - 1][m - 2];
        }
        
        return Arrays.stream(dp[n - 1]).max().getAsInt();
    }
}