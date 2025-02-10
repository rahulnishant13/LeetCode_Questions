// https://leetcode.com/problems/longest-mountain-in-array/description/


class LongestMountaininArray {
    public int longestMountain(int[] arr) {
        int maxVal = 0;
        if (arr.length < 3) return 0;

        for(int i=0; i<arr.length; i++){
            int j = i;
            int count = 1;
            boolean flag = false;

            while(j<arr.length-1 && (arr[j] < arr[j+1])){
                count++;
                j++;
            }
            while(i!=j && j<arr.length-1 && (arr[j] > arr[j+1])){
                count++;
                j++;
                flag = true;
            }

            if(i!=j && flag && count>2){
                maxVal = Math.max(maxVal, count);
                j--;
            }
            i=j;
        }
        return maxVal;
    }
}
