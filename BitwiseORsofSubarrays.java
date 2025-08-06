// https://leetcode.com/problems/bitwise-ors-of-subarrays
// 898. Bitwise ORs of Subarrays

class BitwiseORsofSubarrays {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        
        for(int n : arr) {
            Set<Integer> curr = new HashSet<>();

            for(int x : prev){
                curr.add(x | n);
            }
            curr.add(n);

            result.addAll(curr);
            prev = curr;
        }

        return result.size();
    }
}
