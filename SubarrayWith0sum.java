package LeetCode_Questions;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWith0sum {
    public static void main(String[] args) {
        int [] nums = {5, -3, -1, 1, 1, 6};
        int k = 1;
        System.out.println(subarraySum(nums, k));
        System.out.println(subarraySum0(nums, 0));

    }

    private static Boolean subarraySum0(int [] nums, int k)
    {
        Set<Integer> set = new HashSet<>();
        int sum = k;

        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if (nums[i] == k || sum == k || set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    private static Boolean subarraySum(int[] nums, int k) {
        int N = nums.length;

        for(int i=0; i<N; i++){
            int sum = nums[i];
            for(int j=i+1; j<N; j++){
                if(sum == k){
                    return true;
                }
                sum += nums[j];
            }
            if(sum == k){
                return true;
            }
        }
        return false;
    }
}
