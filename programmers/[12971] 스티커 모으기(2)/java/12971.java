class Solution {
    public int solution(int[] sticker) {
        int length = sticker.length;
        if (length == 1) {
            return sticker[0];
        }
        if (length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        
        int[] dp1 = new int[length - 1];
        dp1[0] = dp1[1] = sticker[0];
        for (int index = 2; index < length - 1; index++) {
            dp1[index] = Math.max(dp1[index - 1], dp1[index - 2] + sticker[index]);
        }
        
        int[] dp2 = new int[length];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for (int index = 2; index < length; index++) {
            dp2[index] = Math.max(dp2[index - 1], dp2[index - 2] + sticker[index]);
        }

        return Math.max(dp1[length - 2], dp2[length - 1]);
    }
}