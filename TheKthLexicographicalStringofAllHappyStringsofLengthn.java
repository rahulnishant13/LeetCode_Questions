// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/

class TheKthLexicographicalStringofAllHappyStringsofLengthn {
    public String getHappyString(int n, int k) {
        String[] st = new String[]{"a","b","c"};
        List<List<String>> result = new ArrayList<>();

        getLastHappyString(st, result, new ArrayList<>(), n, k);
        if(result.size() < k){
            return "";
        }
        StringBuilder res = new StringBuilder();
        for(String s : result.get(k-1)){
            res.append(s);
        }

        return res.toString();
    }

    void getLastHappyString(String[] st, List<List<String>> result, List<String> data, int n, int k){
        if(data.size() == n){
            result.add(new ArrayList<>(data));
            return;
        }

        for(int i=0; i<st.length; i++){
            if(data.size()==0 || !(data.get(data.size()-1).equals(st[i]))){
                data.add(st[i]);
                getLastHappyString(st, result, data, n, k);
                data.remove(data.size()-1);
            }        
        }
    }
}
