// 3306. Count of Substrings Containing Every Vowel and K Consonants II
// https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/

import java.util.HashMap;
import java.util.Map;


class CountofSubstringsContainingEveryVowelandKConsonantsII {
    private static final String VOWELS = "aeiou";

    public long countOfSubstrings(String word, int k) {
        return countOfSubstringsAtLeastK(word, k) - countOfSubstringsAtLeastK(word, k + 1);
    }

    private long countOfSubstringsAtLeastK(String word, int k) {
        Map<Character, Integer> vowelCounts = new HashMap<>();
        int left = 0;
        long result = 0;
        int nonVowelCount = 0;

        for (int right = 0; right < word.length(); right++) {
            char currentChar = word.charAt(right);
            if (VOWELS.indexOf(currentChar) != -1) {
                vowelCounts.put(currentChar, vowelCounts.getOrDefault(currentChar, 0) + 1);
            } else {
                nonVowelCount++;
            }

            while (vowelCounts.size() == 5 && nonVowelCount >= k) {
                result += (word.length() - right); // Count substrings ending at 'right'
                char leftChar = word.charAt(left);
                if (VOWELS.indexOf(leftChar) != -1) {
                    vowelCounts.put(leftChar, vowelCounts.get(leftChar) - 1);
                    if (vowelCounts.get(leftChar) == 0) {
                        vowelCounts.remove(leftChar);
                    }
                } else {
                    nonVowelCount--;
                }
                left++;
            }
        }
        return result;
    }
}
