// 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(row -> row[0]));
        List<int[]> result = new ArrayList<>();

        for(int i=0, j=i+1; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(j<intervals.length && end >= intervals[j][0]){
                end = Math.max(intervals[j][1], end);
                j++;
            }

            result.add(new int[]{start,end});
            i = j-1;
        }

        return result.toArray(new int[0][]);
    }
}
