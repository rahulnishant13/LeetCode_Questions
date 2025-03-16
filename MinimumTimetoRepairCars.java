// 2594. Minimum Time to Repair Cars
// https://leetcode.com/problems/minimum-time-to-repair-cars/

class MinimumTimetoRepairCars {
    public long repairCars(int[] ranks, int cars) {
        long high = (long) ranks[0] * cars * cars;
        long low = 1, result=0;

        // System.out.println(" : " + high);

        while(low <= high) {
            long mid = (low+high)/2;

            if(isValidTime(ranks, mid) >= cars) {
                result = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return result;
    }

    int isValidTime(int[] ranks, long mid) {
        int res = 0;

        for(int rank : ranks) {
            res += Math.sqrt(mid/rank);
        }

        return res;
    }
}
