// 2161. Partition Array According to Given Pivot
// https://leetcode.com/problems/partition-array-according-to-given-pivot/

class PartitionArrayAccordingtoGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] right = new int [n];
        int[] result = new int [n];
        int counts = 0, l = 0, r = 0;

        for (int i=0; i<nums.length; i++) {
            if(nums[i] < pivot) {
                result[l++] = nums[i];
            } else if(nums[i] > pivot) {
                right[r++] = nums[i];
            } else {
                counts++;
            }
        }

        for(int i=0; i<counts; i++) {
            result[l++] = pivot;
        }
        for(int i=0; i<r; i++) {
            result[l++] = right[i];
        }

        return result;
    }
}

// =========================================================================================

class PartitionArrayAccordingtoGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int counts = 0;

        for (int i=0; i<nums.length; i++) {
            if(nums[i] < pivot) {
                left.add(nums[i]);
            } else if(nums[i] > pivot) {
                right.add(nums[i]);
            } else {
                counts++;
            }
        }

        for(int i=0; i<counts; i++) {
            left.add(pivot);
        }

        left.addAll(right);

        return left.stream().mapToInt(Integer::intValue).toArray();
    }
}
