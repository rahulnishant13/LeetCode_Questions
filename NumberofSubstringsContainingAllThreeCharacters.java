// 1358. Number of Substrings Containing All Three Characters
// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

class NumberofSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int result = 0, l=0;
        String st = "abc";
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(st.contains(ch+"")){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            while(map.size() == 3) {
                result += (s.length() - i);
                char chl = s.charAt(l);
                if(st.contains(chl+"")) {
                    map.put(chl, map.getOrDefault(chl, 0) - 1);
                    if(map.get(chl) == 0) {
                        map.remove(chl);
                    }
                }
                l++;
            }
        }

        return result;
    }
}
