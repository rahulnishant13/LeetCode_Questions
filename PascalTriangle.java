package LeetCode_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> list = generate(5);

        System.out.println(list.toString());

    }
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(0, new ArrayList<>(Arrays.asList(1)));
        for (int i = 1; i < numRows; i++) {
            List<Integer> lt = new ArrayList<>();
            List<Integer> lit = list.get(i-1);
            lt.add(lit.get(0));

            for (int j = 0; j < i-1; j++) {
                lt.add(lit.get(j)+lit.get(j+1));
            }

            lt.add(lit.get(lit.size()-1));

            list.add(i, lt);
        }
        return list;
    }
}
