// https://leetcode.com/problems/largest-number/

class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numList = new String[nums.length];
        int i=0;

        for(int num : nums){
            numList[i++] = Integer.toString(num);
        }

        Arrays.sort(numList, (a,b) -> (b+a).compareTo(a+b));
        if(numList[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String st : numList){
            sb.append(st);
        }

        return sb.toString();
    }
}
