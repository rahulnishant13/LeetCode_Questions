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
