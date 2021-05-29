package LeetCode_60_questions_to_solve;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String st = "ynyo";
        System.out.println("rahul nishant "+ lengthOfLongestSubstring(st));
    }

    public static int lengthOfLongestSubstring(String s) {
        Queue<Character> qu = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(!qu.contains(s.charAt(i))) {
                qu.add(s.charAt(i));
                max = Integer.max(max, qu.size());
            } else {
                while (qu.remove() != s.charAt(i)) {
                }
                i = i-1;
            }
        }

        return max;
    }
}
