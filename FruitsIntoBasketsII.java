// https://leetcode.com/problems/fruits-into-baskets-ii
// 3477. Fruits Into Baskets II

class FruitsIntoBasketsII {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int result = 0;
        int flag = 0;

        for(int fruit : fruits){
            flag = 1;
            for(int i=0; i<baskets.length; i++){
                if(fruit <= baskets[i]){
                    baskets[i] = 0;
                    flag = 0;
                    break;
                }
            }

            result += flag;
        }

        return result;
    }
}
