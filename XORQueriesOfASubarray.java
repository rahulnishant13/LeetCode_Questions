// https://leetcode.com/problems/xor-queries-of-a-subarray/


class XORQueriesOfASubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] preXOR = new int[arr.length+1];
        int[] result = new int[queries.length];
        preXOR[0] = 0;

        for(int i=0; i<arr.length; i++){
            preXOR[i+1] = preXOR[i] ^ arr[i];
        }

        for( int k=0; k<queries.length; k++){
            int i = queries[k][0];
            int j= queries[k][1];

            result[k] = preXOR[j+1]^preXOR[i];
        }

        return result;
        
    }
}
