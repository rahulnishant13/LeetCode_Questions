// 1249. Minimum Remove to Make Valid Parentheses
// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean[] arr = new boolean[s.length()];

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            else if(s.charAt(i) == ')'){
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    arr[i] = true;
                }
            }
        }

        while(!stack.isEmpty()){
            arr[stack.pop()] = true;
        }

        for(int i=0; i<s.length(); i++){
            if(!arr[i]){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
