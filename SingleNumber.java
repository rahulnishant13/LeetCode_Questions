package LeetCode_Questions;

public class SingleNumber {
    public static void main(String[] args) {
        int [] nums = {2,2,1};
        System.out.println(singleNumber(nums));
    }
    private static int singleNumber(int[] nums) {
        int num=0;
        for(int i=0; i<nums.length; i++){
            num = num^nums[i];
        }

        return num;
    }
}
