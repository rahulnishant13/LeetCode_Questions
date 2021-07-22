package LeetCode_Questions;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "as";
        String t = "";
        System.out.println(isSubsequence(s, t));
    }

    private static boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        if(s.length() != 0 && t.length() ==0)
            return false;

        int i =0;
        for (int j = 0; j < t.length(); j++) {
            if(s.charAt(i) == t.charAt(j)){
                i++;
                if (i == s.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
