// 2477. Minimum Fuel Cost to Report to the Capital
// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital
class Solution {
    Map<Integer, List<Integer>> roadMap;
    long res = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        if(roads.length == 0){
            return 0;
        }
        roadMap = new HashMap<>();
        for(int[] road : roads){
            roadMap.putIfAbsent(road[0], new ArrayList<>());
            roadMap.putIfAbsent(road[1], new ArrayList<>());
            roadMap.get(road[0]).add(road[1]);
            roadMap.get(road[1]).add(road[0]);
        }
        
        fuelDFS(0, 0, seats);
        return res;
    }

    int fuelDFS(int node, int parent, int seats){
        int people = 1;
        for(int child : roadMap.get(node)){
            if(child != parent){
                people += fuelDFS(child, node, seats);
            }
        }
        if(node > 0){
            res += (people+seats-1)/seats;
        }
        // System.out.println(parent + " : "+node+" : "+people);

        return people;
    }
}
