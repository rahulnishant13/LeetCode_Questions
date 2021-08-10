package LeetCode_Questions;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
    static int titleToNumber(String columnTitle) {
        int sum = 0;
        for (int i = 0; i < columnTitle.length() ; i++) {
            sum += Math.pow(26, columnTitle.length()-i-1)*(columnTitle.charAt(i) -'A' + 1);
        }

        return sum;
    }

//    without power
//    static int titleToNumber(String columnTitle) {
//        int sum = 0;
//        double p = 1;
//        for (int i = columnTitle.length()-1; i >= 0 ; i--) {
//            sum += p*(columnTitle.charAt(i) -'A' + 1);
//            p *= 26;
//        }
//
//        return sum;
//    }

}
