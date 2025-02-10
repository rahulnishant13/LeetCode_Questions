// https://leetcode.com/problems/permutations/?envType=problem-list-v2&envId=5go9wqm5

class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getpermutation(result, new ArrayList(), nums);
        return result;
    }

    private static void getpermutation(List<List<Integer>> result, List<Integer> data, int[] nums){
        if(data.size() == nums.length)
            result.add(new ArrayList<>(data));

        for(int i=0; i<nums.length; i++){
            if(!data.contains(nums[i])){
                data.add(nums[i]);
                System.out.println("before: " + Arrays.toString(data.toArray()) + "  i: " + i);
                getpermutation(result, data, nums);
                data.remove(data.size()-1);
                System.out.println("after : "+Arrays.toString(data.toArray())  + "  i: " + i);

            }
        }
    }

}
