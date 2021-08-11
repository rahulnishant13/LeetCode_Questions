package LeetCode_Questions;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()[[]{]}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
            }
            else if(ch == '{'){
                st.push(ch);
            }
            else if(ch == '['){
                st.push(ch);
            }
            else if(ch == ')'){
                if (!st.isEmpty() && st.peek() == '(')
                    st.pop();
                else
                    return false;
            }
            else if(s.charAt(i) == '}'){
                if (!st.isEmpty() && st.peek() == '{')
                    st.pop();
                else
                    return false;
            }
            else if(s.charAt(i) == ']'){
                if (!st.isEmpty() && st.peek() == '[')
                    st.pop();
                else
                    return false;
            }
        }

        return st.isEmpty();
    }
}
