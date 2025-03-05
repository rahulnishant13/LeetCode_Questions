// 2579. Count Total Number of Colored Cells
// https://leetcode.com/problems/count-total-number-of-colored-cells/
class CountTotalNumberofColoredCells {
    public long coloredCells(int n) {
        long sum = 1;
        for(int i=1; i<n; i++) {
            sum += i*4;
        }
        // 1 + 4 + 8 + 12 + 
        return sum;
    }
}
