// https://leetcode.com/problems/clear-digits/?envType=daily-question&envId=2025-02-10

class ClearDigits {
    public String clearDigits(String s) {
        StringBuilder result = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9' && result.length() > 0){
                result.deleteCharAt(result.length()-1);
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
