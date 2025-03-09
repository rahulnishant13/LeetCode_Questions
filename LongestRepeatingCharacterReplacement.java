// 424. Longest Repeating Character Replacement
// https://leetcode.com/problems/longest-repeating-character-replacement/

class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int result = 0;
        int max = 0;
        int[] chars = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            chars[s.charAt(i) - 'A']++;
            max = Math.max(max, chars[s.charAt(i) - 'A']);

            if((i - l - max + 1) <= k) {
                result = Math.max(result, i-l+1);
            } else {
                chars[s.charAt(l) - 'A']--;
                l++;
            }
        }

        return result;
    }
}
