// https://leetcode.com/problems/find-the-original-typed-string-i/
// 3330. Find the Original Typed String I

class FindtheOriginalTypedStringI {
    public int possibleStringCount(String word) {
        int result = 1;
        char curr = word.charAt(0);

        for(int i=1; i<word.length(); i++){
            if(curr == word.charAt(i)){
                result++;
            } else {
                curr = word.charAt(i);
            }
        }

        return result;
    }
}
