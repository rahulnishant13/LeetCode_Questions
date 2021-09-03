package LeetCode_Questions;

public class LongestMountainInArray {
    public static void main(String[] args) {
        int [] arr = {0,1,2,3,4,5,4,3,2,1,0};
        System.out.println(longestMountain(arr));
    }

//    static int longestMountain(int[] arr) {
//        int maxCount = 0;
//        int acc = 0;
//        int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            if (i < n-1 && arr[i] < arr[i+1]) {
//                while (i < n-1 && arr[i] < arr[i+1]){
//                    i++;
//                }
//                if (i < n-1 && arr[1] > arr[1 + 1]) {
//                    while (i < n - 1 && arr[i] > arr[i + 1]) {
//                        i++;
//                    }
//                    maxCount = Math.max(i + 1 - acc, maxCount);
//                }
//            }
//            acc = Math.max(i, acc + 1);
//        }
//        return maxCount;
//    }

    public static int longestMountain(int[] A) {
        int N = A.length;
        int ans = 0, base = 0;
        while (base < N) {
            int end = base;
            if (end + 1 < N && A[end] < A[end + 1]) {
                while (end + 1 < N && A[end] < A[end + 1]) end++;

                if (end + 1 < N && A[end] > A[end + 1]) {
                    while (end + 1 < N && A[end] > A[end + 1]) end++;
                    ans = Math.max(ans, end - base + 1);
                }
            }

            base = Math.max(end, base + 1);
        }

        return ans;
    }
}
