class Solution {
    public int captureForts(int[] forts) {
        int maxCnt = 0;
        int idx = -1;
        for (int i=0; i<forts.length; i++) {
            if (forts[i] == 1) {
                idx = i;
            } else if (forts[i] == -1 && idx >= 0) {
                maxCnt = Math.max(maxCnt, Math.abs(idx - i) - 1);
                idx = -1;
            }
        }

        idx = -1;
        for (int i=forts.length-1; i>=0; i--) {
            if (forts[i] == 1) {
                idx = i;
            } else if (forts[i] == -1 && idx >= 0) {
                maxCnt = Math.max(maxCnt, Math.abs(idx - i) - 1);
                idx = -1;
            }
        }

        return maxCnt;

        // int size = forts.length;
        // int result = 0;

        // for (int index = 0; index < size; index++) {
        //     if (forts[index] == 1) {
        //         for (int right = index + 1; right < size; right++) {
        //             if (forts[right] == 1) {
        //                 break;
        //             }
        //             if (forts[right] == -1) {
        //                 result = Math.max(result, Math.abs(index - right) - 1);
        //                 break;
        //             }
        //         }

        //         for (int left = index - 1; left >= 0; left--) {
        //             if (forts[left] == 1) {
        //                 break;
        //             }
        //             if (forts[left] == -1) {
        //                 result = Math.max(result, Math.abs(index - left) - 1);
        //                 break;
        //             }
        //         }
        //     }
        // }

        // return result;
    }
}