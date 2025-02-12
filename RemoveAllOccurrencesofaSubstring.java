// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/?envType=daily-question&envId=2025-02-11


class RemoveAllOccurrencesofaSubstring {
    public String removeOccurrences(String s, String part) {
        if(s.length() < part.length()) return s;
        if(s.equals(part)) return "";
        int partSize = part.length();


        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            sb.append(s.charAt(i));
            int sbSize = sb.length();
            if(sbSize >= partSize && (sb.substring(sbSize-partSize, sbSize)).equals(part)){
                sb.delete(sbSize-partSize, sbSize);
            }
        }
        return sb.toString();
    }
}
