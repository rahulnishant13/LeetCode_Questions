// https://leetcode.com/problems/find-the-town-judge/

class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1){ 
            return 1;
        }
       int[] result = new int[n+1];
       int i = 0;

       for(int[] person : trust){
        result[person[0]]--;
        result[person[1]]++;
       }

    //    System.out.println(Arrays.toString(result));

       for(int res: result){
        if(res == n-1){
            return i;
        }
        i++;
       }
       return -1;
    }
}
