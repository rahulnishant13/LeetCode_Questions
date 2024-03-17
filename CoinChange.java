/*
*
* 1, 2, 5
* 11
*
* 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
* 0 1 
*
*/

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] T = new int[amount+1];
        for (int i = 1; i <= amount; i++)
        {
            T[i] = amount+1;
            int result = amount+1;

            for (int c: coins){
                if ((i - c) >= 0){
                    T[i] = Integer.min(T[i], T[i-c] + 1);
                }
            }
        }
        return( T[amount] <= amount ? T[amount] : -1);
    }
}
