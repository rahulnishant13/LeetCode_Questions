// 41. First Missing Positive
// https://leetcode.com/problems/first-missing-positive/

class FirstMissingPositive {
    // marking correct index to negative
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++) {
            if(nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for(int i=0; i<len; i++) {
            int val = Math.abs(nums[i]);
            if((val>=1 && val<=len)) {
                if(nums[val-1] > 0) {
                    nums[val-1] *= -1;
                } else if(nums[val-1] == 0) {
                    nums[val-1] = -1*(len+1);
                }
            }
        }

        for(int i=1; i<len+1; i++) {
            if(nums[i-1] >= 0) {
                return i;
            }
        }

        return len+1;
    }

    // using cyclic sort
    public int firstMissingPositiveUsingCyclicSort(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len;) {
            int val = nums[i] - 1;
            if(nums[i]>0 && nums[i]<=len && nums[i] != nums[val]) {
                int temp = nums[val];
                nums[val] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for(int i=1; i<len+1; i++) {
            if(nums[i-1] != i){
                return i;
            }
        }

        return len+1;
    }
}
