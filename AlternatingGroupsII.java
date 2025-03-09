// 3208. Alternating Groups II
// https://leetcode.com/problems/alternating-groups-ii/

class AlternatingGroupsII {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        if (n < k) {
            return 0;
        }
        int l = 0;
        int count = 0;
    
        for (int i = 1; i < n+k-1; i++) {
            if(colors[i%n] == colors[(i+1)%n]) {
                l = i;
            }
            if (i - l + 1 == k) {
                count++;
                l++;
            }
        }
        return count;
    }
}
