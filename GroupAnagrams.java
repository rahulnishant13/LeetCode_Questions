package LeetCode_Questions;

// https://leetcode.com/problems/group-anagrams/

import javafx.util.Pair;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String st : strs){
            char [] ch = st.toCharArray();
            Arrays.sort(ch);
            String sortedStr = String.valueOf(ch);

            if(map.containsKey(sortedStr)){
                List<String> lt = map.get(sortedStr);
                lt.add(st);
                map.put(sortedStr, lt);
            } else {
                map.put(sortedStr, new ArrayList<>(Arrays.asList(st)));
            }
        }

        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (a,b) -> (a.getValue().size()) > (b.getValue().size()) ? 1 : -1);
        for(Map.Entry<String, List<String>> entry : entries){
            result.add(entry.getValue());
        }

        return result;
    }
}

// ========================================================== sol 2 ============

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapWord = new HashMap<>();

        for(String st : strs){
            char [] ch = st.toCharArray();
            Arrays.sort(ch);
            String word = new String(ch);

            if(!mapWord.containsKey(word)){
                mapWord.put(word, new ArrayList<>());
            }
            List<String> temp = mapWord.get(word);
            temp.add(st);
        }

        List<List<String>> result = new ArrayList<>();

        for(var data : mapWord.values()){
            result.add(data);
        }


        return result;
    }

}
