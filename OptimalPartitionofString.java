// 2405. Optimal Partition of String
// https://leetcode.com/problems/optimal-partition-of-string/

class OptimalPartitionofString {
    public int partitionString(String s) {
        Set<Character> charSet = new HashSet<>();
        int res = 1;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(charSet.contains(ch)) {
                res++;
                charSet = new HashSet<>();
            }
            charSet.add(ch);
        }

        return res;
    }
}
