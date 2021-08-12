package LeetCode_Questions;


public class Pow_x_n {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(myPow(x, n));
    }
    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        else if (n < 0)
            return 1 / getPow(x, n);
        else
            return getPow(x, n);
    }

    public static double getPow(double x, int y) {
        double result = 1.0;
        long n = (long) (y > 0 ? y: (-1.00)*y);
        while (n > 0){
            if(n%2 == 1){
                result *= x;
                n = n-1;
            } else {
                x = x*x;
                n = n/2;
            }
        }

        return result;
    }
}
