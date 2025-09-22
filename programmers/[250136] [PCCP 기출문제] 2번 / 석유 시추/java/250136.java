import java.util.*;

class Solution {
    private int X;
    private int Y;
    private int[][] land;
    private List<Integer> petroleum = new ArrayList<>();
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int index = -1;
    
    public int solution(int[][] land) {
        this.land = land;
        X = land.length;
        Y = land[0].length;
        
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                if (land[x][y] == 1) {
                    petroleum.add(computeSums(x, y));
                    index--;
                }
            }
        }
        
        int max = 0;
        for (int lane = 0; lane < Y; lane++) {
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            
            for (int x = 0; x < X; x++) {
                if (land[x][lane] != 0) {
                    set.add(land[x][lane]);
                }
            }
            
            for (int number : set) {
                sum += petroleum.get(number * -1 - 1);
            }
            
            if (max < sum) {
                max = sum;
            }
        }
        
        return max;
    }
    
    private int computeSums(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        land[x][y] = index;
        int sum = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            sum++;
            
            for (int[] direction : directions) {
                int nx = current[0] + direction[0];
                int ny = current[1] + direction[1];
                
                if (!isIn(nx, ny) || land[nx][ny] != 1) {
                    continue;
                }
                
                queue.add(new int[] {nx, ny});
                land[nx][ny] = index;
            }
        }
        
        return sum;
    }
    
    private boolean isIn(int x, int y) {
        return 0 <= x && x < X && 0 <= y && y < Y;
    }
}