// https://leetcode.com/problems/permutations-ii
// 47. Permutations II

class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int[] used = new int[nums.length];

        helper(nums, result, new ArrayList<>(), used);

        return new ArrayList<>(result);
    }

    void helper(int[] nums, Set<List<Integer>> result, List<Integer> data, int[] used){
        if(data.size() == nums.length){
            result.add(new ArrayList(data));
        }

        for(int i=0; i<nums.length; i++){
            if(used[i] == 0){
                data.add(nums[i]);
                used[i] = 1;
                helper(nums, result, data, used);
                data.remove(data.size() -1);
                used[i] = 0;
            }
        }
    }

}
