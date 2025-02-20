// https://leetcode.com/problems/word-ladder/description/

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordLis) {
        Set<String> wordList = new HashSet<>(wordLis);
        if(!wordList.contains(endWord)){
            return 0;
        }

        Queue<String> wordQueue = new LinkedList<>();
        wordQueue.add(beginWord);
        int result = 1;

        while(!wordQueue.isEmpty()){
            int size = wordQueue.size();
            boolean flag = false;
            for(int i=0; i<size; i++){
                String word = wordQueue.poll();
                if(word.equals(endWord)){
                    return result;
                }
                for(int j=0; j<word.length(); j++){
                    for(char k='a'; k<='z'; k++){
                        String newWord = new String(word);
                        newWord = newWord.substring(0,j) + k + newWord.substring(j+1, word.length());
                        if(wordList.contains(newWord)){
                            wordQueue.add(newWord);
                            wordList.remove(newWord);
                            flag = true;
                        }
                    }
                }
            }
            if(flag){
                result++;
            }
        }

        return 0;
    }
}
