package LeetCode_Questions;


public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        int len = Math.min(s.length(), numRows);
        String resultString  = "";
        StringBuilder [] zz = new StringBuilder[len];
        int j =0;
        while(j<s.length()){
            for (int i = 0; i < numRows && j<s.length(); i++) {
                if(zz[i] == null)
                    zz[i] = new StringBuilder();
                zz[i].append(s.charAt(j++));
            }
            for (int i = numRows-2; i > 0 && j<s.length(); i--) {
                zz[i].append(s.charAt(j++));
            }
        }
        for (int i = 0; i < len; i++) {
            resultString += zz[i];
        }
        return resultString;
    }
}
