package LeetCode_Questions;

import java.util.Stack;

public class ValidateStackSequences {
    public static void main(String[] args) {
        int [] pushed = new int[]{1,2,3,4,5};
        int [] popped = new int[]{4,5,3,2,1};

        System.out.println(validateStackSequences(pushed, popped));
    }

    private static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length)
            return false;

        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            st.push(pushed[i]);
            while (!st.empty() && st.peek() == popped[j]){
                j++;
                st.pop();
            }
        }

        return st.empty();
    }
}
