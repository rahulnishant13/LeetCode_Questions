// 1007. Minimum Domino Rotations For Equal Row
// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/


class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // int[] commonNum = new int[7];
        int result = Integer.MAX_VALUE;
        
        for(int x=1; x<7; x++) {
            int count = 0, topCount = 0, botCount = 0;
            for(int i=0; i<tops.length; i++) {
                if(x == tops[i] || x == bottoms[i]) {
                    count++;
                    if(x == tops[i]){
                        topCount++;
                    }
                    if(x == bottoms[i]) {
                        botCount++;
                    }
                } else {
                    break;
                }
            }
            if(count == tops.length) {
                // commonNum[x] = tops.length - Math.max(topCount, botCount);
                result = Math.min(tops.length - Math.max(topCount, botCount), result);
            }
        }

        // int result = Integer.MAX_VALUE;
        // for(int num : commonNum) {
        //     if(num != 0){
        //         result = Math.min(num, result);
        //     }
        // }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
