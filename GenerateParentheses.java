package LeetCode_Questions;

import java.util.*;

public class GenerateParentheses {

    public static void main(String[] args) {
        int x = 3;
        System.out.println(generateParenthesis(x));

    }

//    iterative way
//    private static List<String> generateParenthesis(int n) {
//        if (n == 1){
//            return new ArrayList<String>(Arrays.asList("()"));
//        }
//        Set<String> set = new HashSet<String>();
//        set.add("()");
//        for (int k = 2; k <= n; k++) {
//            Set<String> baba = new HashSet<>();
//            for (String s : set) {
//                baba.add("()" + s);
//                for (int i = 0; i < s.length() - 1; i++) {
//                    baba.add(s.substring(0, i + 1) + "()" + s.substring(i + 1, s.length()));
//                }
//                baba.add(s + "()");
//            }
//            set = baba;
//        }
//        return new ArrayList<>(set);
//    }

//    using recursion
    private static List<String> generateParenthesis(int n) {
        if (n == 1){
            return new ArrayList<String>(Arrays.asList("()"));
        }
        List<String> list = generateParenthesis(n-1);
        Set<String> set = new HashSet<>();
        for (String st: list) {
            for (int i = -1; i < st.length(); i++) {
                set.add(st.substring(0, i+1) + "()" + st.substring(i+1, st.length()));
            }
        }
        return new ArrayList<>(set);
    }
}