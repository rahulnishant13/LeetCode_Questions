// https://leetcode.com/problems/partition-labels/description/
// 763. Partition Labels

class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] letters = new int[26] ;
        List<Integer> result = new ArrayList<>();
        int l = 0;
        for(char ch : s.toCharArray()){
            letters[ch-'a'] = l;
            l++;
        }

        l=0;
        int maxIdx = 0;
        for(int i=0 ; i<s.length(); i++){
            maxIdx = Math.max(letters[s.charAt(i) -'a'], maxIdx);
            l++;
            if(maxIdx == i){
                result.add(l);
                l=0;
            }
        }
        return result;
    }
}

// ====================================== solution II ===============================

class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] letters = new int[26] ;
        Set<Character> charSet = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(char ch : s.toCharArray()){
            letters[ch-'a']++;
        }
        int l = 0;
        for(int i=0 ; i<s.length(); i++){
            char ch = s.charAt(i);
            charSet.add(ch);
            letters[ch -'a'] --;
            if(letters[ch-'a'] == 0){
                charSet.remove(ch);
            }
            if(charSet.size() ==0){
                result.add(i-l+1);
                l=i+1;
            }
        }
        return result;
    }
}
