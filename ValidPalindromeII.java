// 680. Valid Palindrome II
// https://leetcode.com/problems/valid-palindrome-ii/

class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if(checkPalin(s, false)) return true;
        if(checkPalin(s, true)) return true;

        return false;
    }

    boolean checkPalin(String s, boolean left) {
        int l=0, r = s.length()-1, k = 1;
        while(l<=r) {
            if(s.charAt(l) != s.charAt(r)) {
                if(k <= 0) {
                    return false;
                }
                if(left) {
                    l++;
                } else {
                    r--;
                }
                k--;
            } else {
                l++;
                r--;
            }
        }

        return true;
    }
}
