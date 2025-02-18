// https://leetcode.com/problems/construct-smallest-number-from-di-string/

class ConstructSmallestNumberFromDIString {
    public String smallestNumber(String pattern) {
        int len = pattern.length();
        StringBuilder sb = new StringBuilder();
        int[] stack = new int[len+1];
        int k=0;

        for(int i=0; i<=len; i++){
            stack[k] = i+1;
            k++;

            if(i == len || pattern.charAt(i) == 'I'){
               while(k > 0){
                k--;
                sb.append(stack[k]);
               }
            }
        }

        // System.out.println(sb.toString());

        return sb.toString();
    }
}
