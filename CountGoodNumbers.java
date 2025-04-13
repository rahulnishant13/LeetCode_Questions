// https://leetcode.com/problems/count-good-numbers
// 1922. Count Good Numbers

class CountGoodNumbers {
    int mod = 1000000007;
    public int countGoodNumbers(long n) {
        // long evenIdx = 0;
        // long primeIdx = 0;
        

        // if(n%2 == 0){
        //     evenIdx = n/2;
        //     primeIdx = n/2;
        // } else {
        //     evenIdx = (n+1)/2;
        //     primeIdx = n/2;
        // }

        return (int)((getMultiple(5, (n+1)/2) * getMultiple(4, n/2))%mod);
    }

    long getMultiple(int val, long index){
        long result = 1;
        long mul = val;

        while(index>0) {
            if(index%2 == 1) {
                result = (result * mul)%mod;
            }

            mul = (mul*mul)%mod;
            index /= 2;
        }

        return result;
    }
}
