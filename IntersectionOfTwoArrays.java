package LeetCode_Questions;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int [] nums1 = {1,2,2,1}, nums2 = {2,2};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> result = new HashSet<Integer>();
        int max = Math.max(nums1.length, nums2.length);
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }

        int [] res = new int[result.size()];
        int i =0;
        for (Integer dat:result) {
            res[i++] = dat;
        }
        return res;
    }

//    private static int[] intersection(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        Set<Integer> set = new HashSet<Integer>();
//
//        for (int i = 0, j=0; i < nums1.length && j < nums2.length; ) {
//            if(nums1[i] == nums2[j]){
//                set.add(nums1[i]);
//                j++;
//                i++;
//            } else {
//                if(nums1[i] > nums2[j])
//                    j++;
//                else
//                    i++;
//            }
//        }
//
//        int [] res = new int[set.size()];
//        int i =0;
//        for (Integer dat:set) {
//            res[i++] = dat;
//        }
//        return res;
//    }
}
