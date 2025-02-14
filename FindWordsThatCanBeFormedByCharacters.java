// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int count = 0;
        for(String word : words){
            if(checkWordCanBeFormed(word, chars)){
                count = count + word.length();
            }
        }

        return count;
    }

    private static boolean checkWordCanBeFormed(String word, String chars){
        int [] charWords = new int[26];

        for(int i=0; i<chars.length(); i++){
            charWords[chars.charAt(i) - 'a']++;
        }

        for(int i=0; i<word.length(); i++){
            if(charWords[word.charAt(i) - 'a'] == 0){
                return false;
            }
            charWords[word.charAt(i) - 'a']--;
        }

        return true;
    }
}

// =======================================================================================================================

class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charMap = new HashMap<>();
        Map<Character, Integer> wordMap;
        int result = 0;
        
        for(int i=0; i<chars.length(); i++){
            charMap.put(chars.charAt(i), charMap.getOrDefault(chars.charAt(i), 0) + 1);
        }

        for(String word : words){
            wordMap = new HashMap<>();
            boolean flag = true;
            for(int i=0; i<word.length(); i++){
                wordMap.put(word.charAt(i), wordMap.getOrDefault(word.charAt(i), 0) + 1);
                if(wordMap.getOrDefault(word.charAt(i), 0) > charMap.getOrDefault(word.charAt(i), 0)){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                result = result + word.length();
            }
        }

        return result;
    }
}
