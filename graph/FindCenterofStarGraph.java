// Find Center of Star Graph
// https://leetcode.com/problems/find-center-of-star-graph/

class FindCenterofStarGraph {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] edge : edges){
            map.put(edge[0], map.getOrDefault(edge[0], 0)+1);
            map.put(edge[1], map.getOrDefault(edge[1], 0)+1);
        }

        for(var entry : map.entrySet()){
            if(entry.getValue() == edges.length){
                return entry.getKey();
            }
        }

        return -1;
    }
}
