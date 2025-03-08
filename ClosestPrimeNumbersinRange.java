// 2523. Closest Prime Numbers in Range
// https://leetcode.com/problems/closest-prime-numbers-in-range/


class ClosestPrimeNumbersinRange {
    public int[] closestPrimes(int left, int right) {
        int prime1 = -1, diff = Integer.MAX_VALUE;
        int[] result = new int[]{-1,-1};

        for(int i=left; i<=right; i++){
            if(checkPrime(i)) {                
                if(prime1 != -1 && diff > (i - prime1)) {
                    diff = i - prime1;
                    result = new int[]{prime1,i};
                }
                if(diff == 2) {
                    break;
                }
                prime1 = i;
            }
        }

        return result;
    }

    boolean checkPrime(int num) {
        if(num < 2) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }

        return true;
    }
}
