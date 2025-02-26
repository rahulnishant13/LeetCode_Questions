// https://leetcode.com/problems/longest-mountain-in-array/
// 845. Longest Mountain in Array
class LongestMountaininArray {
    public int longestMountain(int[] arr) {
        int result = 0;
        int n = arr.length;

        for(int i=0; i<n; i++) {
            int j = i;
            int count = 0;
            boolean flag = false;

            while(j<n-1 && arr[j] < arr[j+1]){
                count++;
                j++;
            }
            while(i!=j && j<n-1 && arr[j] > arr[j+1]){
                count++;
                j++;
                flag = true;
            }
 
            if(i!=j && flag) {
                result = Math.max(result, count+1);
                j--;
            }
            i = j;
        }

        return result;
    }
}
