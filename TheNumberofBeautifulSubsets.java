// https://leetcode.com/problems/the-number-of-beautiful-subsets/

class TheNumberofBeautifulSubsets {
    public int beautifulSubsets(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();

        getBeautifulSubsets(nums, result, new ArrayList(), 0, k);

        // System.out.println(" : " + Arrays.toString(result.toArray()));

        return result.size()-1;

    }

    private void getBeautifulSubsets(int[] nums, List<List<Integer>> result, List<Integer> data, int index, int target){
        
        result.add(new ArrayList<>(data));
        
        for(int i=index; i<nums.length; i++){
            if(isValid(data, target, nums[i])){
                data.add(nums[i]);
                getBeautifulSubsets(nums, result, data, i+1, target);
                data.remove(data.size()-1);
            }
            
        }
    }

    boolean isValid(List<Integer> data, int target, int curr){
        for(int i=0; i<data.size(); i++){
            if(Math.abs(data.get(i) - curr) == target){
                return false;
            }
        }
        return true;
    }
}
