// 1399. Count Largest Group
// https://leetcode.com/problems/count-largest-group/

class CountLargestGroup {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i=1; i<=n; i++) {
            int sum = 0;
            int num = i;

            while(num > 0) {
                sum += num%10;
                num = num/10;
            }

            numMap.put(sum, numMap.getOrDefault(sum, 0) + 1);
        }

        int max = 0;
        int count = 1;

        for(int i : numMap.values()) {
            if(i == max){
                count++;
            }
            else if(max < i) {
                max = i;
                count = 1;
            }
        }

        return count;
    }
}
