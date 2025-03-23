// 2034. Stock Price Fluctuation 
// https://leetcode.com/problems/stock-price-fluctuation/

class StockPriceFluctuation {
    Map<Integer, Integer> map;
    PriorityQueue<int[]> minQueue;
    PriorityQueue<int[]> maxQueue;
    int current = 0;

    public StockPrice() {
        map = new HashMap<>();
        this.minQueue = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[1], b[1]));
        this.maxQueue = new PriorityQueue<int[]>((a,b) -> Integer.compare(b[1], a[1]));
    }
    
    public void update(int timestamp, int price) {
        minQueue.offer(new int[]{timestamp, price});
        maxQueue.offer(new int[]{timestamp, price});
        map.put(timestamp, price);
        current = Math.max(current, timestamp);
    }
    
    public int current() {
        return map.get(current);
    }
    
    public int maximum() {
        while(true) {
            int[] data = maxQueue.peek();
            if(data[1] == map.get(data[0])) {
                return data[1];
            }
            maxQueue.poll();
            // System.out.println(data[0] +" r:n "+data[1]);
        }
    }
    
    public int minimum() {
        while(true) {
            int[] data = minQueue.peek();
            if(data[1] == map.get(data[0])) {
                return data[1];
            }
            minQueue.poll();
            // System.out.println(data[0] +" d:p "+data[1]);
        }
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
