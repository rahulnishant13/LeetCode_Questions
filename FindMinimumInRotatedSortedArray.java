package LeetCode_Questions;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int [] nums = {11,13,15,17};
        System.out.println(getMin(nums, 0, nums.length-1));
    }

    private static int getMin(int [] arr, int low, int high){
        if (low > high)
            return -1;
        if(arr[low] <= arr[high])
            return arr[low];

        int mid = (low+high)/2;

        if(mid > 0 && mid < arr.length-1 && arr[mid-1] > arr[mid] && arr[mid] < arr[mid+1])
            return arr[mid];

        if(arr[mid] > arr[high])
            return getMin(arr, mid+1, high);
        return getMin(arr, low, mid);
    }
}
