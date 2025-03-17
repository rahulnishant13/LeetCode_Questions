// 2206. Divide Array Into Equal Pairs
// https://leetcode.com/problems/divide-array-into-equal-pairs

class DivideArrayIntoEqualPairs {
    public boolean divideArray(int[] nums) {
        // Map<Integer, Integer> dataMap = new HashMap();
        int[] freq = new int[501];
    
        for(int num : nums) {
            // dataMap.put(num, dataMap.getOrDefault(num, 0) + 1);
            freq[num]++;
        }

        // for(Map.Entry<Integer, Integer> entry : dataMap.entrySet()) {
        //     if(entry.getValue()%2 != 0) {
        //         return false;
        //     }
        // }

        for(int num : freq) {
            if(num%2 != 0){
                return false;
            }
        }
        
        return true;
    }
}
