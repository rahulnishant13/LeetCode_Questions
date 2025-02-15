// https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/

class FindthePunishmentNumberofanInteger {
    public int punishmentNumber(int n) {
        int result =0;

        for(int i=1; i<=n; i++){
            int sqr = i*i;

            boolean x= canPartition(i, sqr);
            if(x){
                result += sqr;
            }
        }

        return result;
    }

    boolean canPartition(int target, int sqr){
        if(target > sqr || target < 0){
            return false;
        }
        if(target == sqr){
            return true;
        }

        return (canPartition(target - sqr%10, sqr/10) || canPartition(target - sqr%100, sqr/100) || canPartition(target - sqr%1000, sqr/1000));
    }
}
