// https://leetcode.com/problems/merge-sorted-array/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        if(m == 0){
            for(int l = 0; l < n; l++){
                nums1[l] = nums2[l];
            }
            return;
        }

        int i = m-1, j = n-1, k= m+n-1;

        while(i >= 0 && j >= 0){
            if(nums1[i] <= nums2[j]){
                nums1[k] = nums2[j];
                j--;
                k--;
            }
            else{
                nums1[k] = nums1[i];
                k--;
                i--;
            }
        }
        if(j >= 0){
             for(int l = j; l >= 0; l--){
                nums1[l] = nums2[l];
            }
        }
    }
}


// =================================================================================================
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=0, j=0; i<m+n && j<n;) {
            if(i>=(m+j) && nums1[i] == 0){
                nums1[i] = nums2[j];
                i++;
                j++;
            } else if(nums1[i] <= nums2[j]){
                i++;
            } else {
                addAndShiftInteger(nums1, i, nums2[j]);
                j++;
                i++;
            }
        }
    }

    private static void addAndShiftInteger(int [] nums1, int index, int num){
        // System.out.println(index + " : " + num + " : nums1 : " + Arrays.toString(nums1));
        int temp = nums1[index];
        nums1[index] = num;
        index++;
        while(index < nums1.length){
            num = temp;
            temp = nums1[index];
            nums1[index] = num;
            num = temp;
            index++;
        }
    }
}
