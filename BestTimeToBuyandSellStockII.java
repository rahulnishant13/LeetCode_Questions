package LeetCode_Questions;

public class BestTimeToBuyandSellStockII {
    public static void main(String[] args) {
        int [] prices = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }
    private static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length-1; i++){
            if (prices[i] < prices[i+1]){
                profit += prices[i+1] - prices[i];
            }
        }

        return profit;
    }
}
