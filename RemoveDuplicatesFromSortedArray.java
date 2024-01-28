class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int index =1, k=nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] != k){
                nums[index] = nums[i];
                k = nums[i];
                index++;
            }
        }

        return index;
    }
}
