// https://leetcode.com/problems/count-and-say/
// 38. Count and Say

class CountandSay {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for(int i=1; i<n; i++) {
            sb = compress(sb.toString());
        }

        return sb.toString();
    }

    StringBuilder compress(String sb) {
        int i = 0;
        int count = 1;

        StringBuilder stb = new StringBuilder();

        while(i<(sb.length()-1)) {
            if(sb.charAt(i) == sb.charAt(i+1)) {
                i++;
                count++;
            } else {
                stb.append(count + "" + sb.charAt(i));
                count = 1;
                i++;
            }
        }

        if(i<sb.length()) {
             stb.append(count + "" + sb.charAt(i));
        }

        return stb;
    }
}
