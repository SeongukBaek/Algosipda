class Solution {
    private int[][] map;
    
    public int solution(int n, int w, int num) {
        int h = n % w > 0 ? n / w + 1 : n / w;
        map = new int[h][w];
        
        fillBox(n, w, h);
        
        return getBox(num, w, h);
    }
    
    private void fillBox(int n, int w, int h) {
        boolean isRight = true;
        int box = 1;
        
        for (int x = h - 1; x >= 0; x--) {
            if (isRight) {
                for (int y = 0; y < w; y++) {
                    map[x][y] = box++;
                    
                    if (box > n) {
                        return;
                    }
                }
                isRight = false;
            } else {
                for (int y = w - 1; y >= 0; y--) {
                    map[x][y] = box++;
                    
                    if (box > n) {
                        return;
                    }
                }
                isRight = true;
            }
        }
    }
    
    private int getBox(int target, int w, int h) {
        int targetX = h - (target % w == 0 ? target / w : target / w + 1);
        int targetY = 0;
        
        for (int y = 0; y < w; y++) {
            if (map[targetX][y] == target) {
                targetY = y;
                break;
            }
        }
        
        int box = 1;
        for (int x = targetX - 1; x >= 0; x--) {
            if (map[x][targetY] != 0) {
                box++;
            } else {
                break;
            }
        }
        return box;
    }
}