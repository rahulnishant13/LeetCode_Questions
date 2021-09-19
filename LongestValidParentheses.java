package LeetCode_Questions;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()()"));
        System.out.println(longestValidParenthesesStack("(()))"));
    }

    private static int longestValidParentheses(String s) {
        int open =0, close =0, max =0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                open++;
            else
                close++;

            if(open == close){
                max = Math.max(max, open+close);
            }
        }

        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '(')
                open++;
            else
                close++;

            if(open == close){
                max = Math.max(max, open+close);
            }
        }

        return max;
    }

    private static int longestValidParenthesesStack(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        int max = 0;
        index.add(-1);


        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add('(');
                index.add(i);
            }
            else {
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                    index.pop();
                    max = Math.max(max, i - index.peek());
                }else {
                    index.add(i);
                }
            }
        }

        return max;
    }
}
