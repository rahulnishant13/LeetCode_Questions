package LeetCode_Questions;

import java.util.*;
/*
1 1 1 2 2 1 3 3 3 4 3 4
 1:4
 2:2
 3:4
 4:2
 k=3
 3 1 4 2

 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int [] nums = new int[]{1,1,1,2,2,1,3,3,3,4,3,4};
        int k = 3;
        nums = topKFrequent(nums, k);
        for ( int num : nums) System.out.println(" " + num);
    }
    private static int[] topKFrequent(int[] nums, int k) {
        int [] result = new int [k];
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        for (Integer num : nums){
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(countMap.entrySet());
//        Collections.sort(list, (a, b) -> a.getValue() > b.getValue() ? -1 :
//                a.getValue() == b.getValue() ? (a.getKey() > b.getKey() ? -1 : 1) : 1);

//        Collections.sort(list, (a,b) -> b.getValue().compareTo(a.getValue()));

//        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                if(o1.getValue() > o2.getValue())
//                    return -1;
//                if(o1.getValue() == o2.getValue())
//                    return o1.getKey() > o2.getKey() ? -1 : 1;
//
//                return 1;
//            }
//        });

        Collections.sort(list, (a,b) -> b.getValue().equals(a.getValue())
                                ? b.getKey().compareTo(a.getKey())
                                : b.getValue().compareTo(a.getValue())
                        );


        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}
