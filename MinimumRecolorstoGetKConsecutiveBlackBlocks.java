// 2379. Minimum Recolors to Get K Consecutive Black Blocks
// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int len = blocks.length();
        int min = Integer.MAX_VALUE;
        

        for(int i=0; i<=(len-k); i++) {
            int dataW = 0;
            for(int j=i; j<(i+k); j++) {
                if(blocks.charAt(j) == 'W') {
                    dataW += 1;
                }
            }

            // System.out.println(dataW);

            if(dataW != 0){
                min = Math.min(min, dataW);
            } else {
                return 0;
            }
        }

        return min;
    }
}
