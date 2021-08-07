package LeetCode_Questions;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(10));
    }

    private static boolean isHappy(int n){
        Set<Integer> set = new HashSet<>();
        while (n != 1){
            int k =0;
            while(n != 0){
                k += (n % 10) * (n % 10);
                n /= 10;
            }
            n = k;
            if(!set.add(k))
                return false;
        }
        return true;
    }
}
