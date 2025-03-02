// 443. String Compression
// https://leetcode.com/problems/string-compression/description/

class StringCompression {
    public int compress(char[] chars) {
        char prevChar = chars[0];
        int count = 1;
        int k = 0;
        for(int i=1; i<chars.length; i++){
            if(prevChar != chars[i]) {
                chars[k++] = prevChar;
                if(count > 1){
                    for (char digit : Integer.toString(count).toCharArray()) {
                        chars[k++] = digit;
                    }
                }
                count = 1;
                prevChar = chars[i];
            } else {
                count++;
            }
        }

        chars[k++] = prevChar;
        if(count > 1){
            for (char digit : Integer.toString(count).toCharArray()) {
                chars[k++] = digit;
            }
        }

        return k;
    }
}

// ================================================================================================
class StringCompression {
    public int compress(char[] chars) {
        char prevChar = chars[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<chars.length; i++){
            if(prevChar != chars[i]) {
                sb.append(prevChar);
                if(count > 1){
                    sb.append(count);
                }
                count = 1;
                prevChar = chars[i];
            } else {
                count++;
            }
        }

        sb.append(prevChar);
        if(count > 1){
            sb.append(count);
        }

        int i =0;
        for(char ch : sb.toString().toCharArray()) {
            chars[i] = ch;
            i++;
        }

        System.out.println(sb.toString());

        return sb.length();
    }
}
