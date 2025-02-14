// https://leetcode.com/problems/product-of-the-last-k-numbers/description/

class ProductOfTheLastKNumbers {
    List<Integer> productNums;
    int prod = 1;

    public ProductOfTheLastKNumbers() {
        productNums = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0){
            productNums = new ArrayList<>();
            prod = 1;
            return;
        }
        prod = prod * num;
        productNums.add(prod);
    }
    
    public int getProduct(int k) {
        // System.out.println(k + " : " + Arrays.toString(productNums.toArray()));
        if(productNums.size() < k) return 0;

        if(productNums.size() == k) return productNums.get(productNums.size()-1);

        return productNums.get(productNums.size()-1) / productNums.get(productNums.size()-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
