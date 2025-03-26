// 3394. Check if Grid can be Cut into Sections
// https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/

class CheckifGridcanbeCutintoSections {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int len = rectangles.length;
        int[][] x = new int[len][2];
        int[][] y = new int[len][2];
        int i = 0;

        for(int[] data : rectangles) {
            x[i][0] = data[0];
            x[i][1] = data[2];
            y[i][0] = data[1];
            y[i][1] = data[3];
            i++;
        }

        Arrays.sort(x, Comparator.comparingInt(arr -> arr[0]));
        Arrays.sort(y, Comparator.comparingInt(arr -> arr[0]));

        return Math.max(getOverlappingIntervals(x), getOverlappingIntervals(y)) >= 3;
    }

    int getOverlappingIntervals(int[][] intervals) {
        int count = 0;
        int prev_end = -1;

        for(int[] data : intervals) {
            if(prev_end <= data[0]) {
                count++;
            }

            prev_end = Math.max(prev_end, data[1]);
        }

        return count;
    }
}
