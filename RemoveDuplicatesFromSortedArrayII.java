class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int k=1;
        int x = nums[0];
        for(int i=1; i<nums.length; i++){
            if(x != nums[i]){
                x = nums[i];
                nums[k] = x;
                k++;
            }
        }
        return k;
    }
}
