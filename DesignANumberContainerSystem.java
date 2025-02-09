// https://leetcode.com/problems/design-a-number-container-system/description/?envType=daily-question&envId=2025-02-09
// 2349. Design a Number Container System

class DesignANumberContainerSystem {

    Map<Integer, Integer> indexToNum;
    Map<Integer, PriorityQueue<Integer>> numToIndex;

    public NumberContainers() {
        indexToNum = new HashMap<>();
        numToIndex = new HashMap<>();
    }
    
    public void change(int index, int number) {
        int data = indexToNum.getOrDefault(index, 0);

        if (number == data) return;

        if(data != 0){
            numToIndex.get(data).remove(index);
        }

        // PriorityQueue<Integer> indexes = numToIndex.getOrDefault(number, new PriorityQueue<>());
        // indexes.offer(index);
        // numToIndex.put(number, indexes);
        indexToNum.put(index, number);
        numToIndex.computeIfAbsent(number, x -> new PriorityQueue<>()).offer(index);
    }
    
    public int find(int number) {
        PriorityQueue<Integer> num = numToIndex.getOrDefault(number, new PriorityQueue<>());
        return num.isEmpty() ? -1 : num.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
