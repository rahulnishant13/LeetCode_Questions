package LeetCode_Questions;


public class TwoUniqueNumbers {

    public static void uniqueNumbers(int[] arr, int n)
    {
        int sum =0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ arr[i];
        }

        int rmbs = sum & -sum;
        int num1=0;
        int num2=0;

        for (int i = 0; i < arr.length; i++) {
            if((arr[i] & rmbs) == 0){
                num1 = num1 ^ arr[i];
            } else {
                num2 = num2 ^ arr[i];
            }
        }

        System.out.println("1st num "+num1+" 2nd num "+num2);
    }

    public static void main(String[] args)
    {
        int[] arr = new int[] { 2, 3, 7, 9, 11, 2, 3, 11 , 3, 3};
        int n = arr.length;
        uniqueNumbers(arr, n);
    }
}
