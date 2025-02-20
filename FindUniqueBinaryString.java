// Find Unique Binary String
// https://leetcode.com/problems/find-unique-binary-string/description/

class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        List<String> result = new ArrayList<>();
        List<String> numList = Arrays.asList(nums);

        getDifferentBinaryString(result, new StringBuilder(), new String[]{"0", "1"}, numList);
        return result.get(0);
    }

    void getDifferentBinaryString(List<String> result, StringBuilder data, String[] nums, List<String> numList){
        if(data.length() == numList.size()){
            if(!numList.contains(data.toString())) {
                result.add(data.toString());
            }
            return;
        }

        for(int i=0; i<nums.length; i++){
            data.append(nums[i]);
            getDifferentBinaryString(result, data, nums, numList);
            data.deleteCharAt(data.length()-1);
            if(result.size() > 0){
                return;
            }
        }
    }  
}

//=======================================================================================
class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length - 1;
        for(String num : nums){
            int intNum = 0;
            for(int i=0; i<=n; i++){
                if(num.charAt(n-i) == '1'){
                    intNum += Math.pow(2, i);
                }
            }
            pq.add(intNum);
            // System.out.println(intNum);
        }

        int result = 0;
        while(!pq.isEmpty()){
            if(pq.poll() - result == 0){
                result++;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<=n; i++){
            sb.append(result % 2);
            result = result / 2;
        }

        return sb.reverse().toString();
    }
}
