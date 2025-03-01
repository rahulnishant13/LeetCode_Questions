// 1547. Minimum Cost to Cut a Stick
// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

class MinimumCosttoCutaStick {
    Map<String, Integer> costMap;
    public int minCost(int n, int[] cuts) {
        costMap = new HashMap<>();

        return dfs(cuts, 0, n);
    }

    int dfs(int[] cuts, int l, int r) {
        if(r-l == 1) {
            return 0;
        }

        if(costMap.containsKey(l+","+r)) {
            return costMap.get(l+","+r);
        }

        int result = Integer.MAX_VALUE;
        for(int cut : cuts) {
            if(cut > l && cut < r) {
                result =  Math.min(result, dfs(cuts, l, cut) + dfs(cuts, cut, r) + (r-l));
            }
        }
        result = (result == Integer.MAX_VALUE) ? 0 : result;
        costMap.put(l+","+r, result);
        return result;
    }
}
