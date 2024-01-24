class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = 0, diff = 0, low = prices[0];
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < low) low = prices[i];
            diff = prices[i] - low;
            max = max > diff ? max : diff;

        }

        return max;
    }
}
