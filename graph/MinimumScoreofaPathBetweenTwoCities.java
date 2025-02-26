// 2492. Minimum Score of a Path Between Two Cities
// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/

class MinimumScoreofaPathBetweenTwoCities {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> roadMap = new HashMap<>();
        // Map<String, Integer> weightMap = new HashMap<>();

        for(int[] road : roads) {
            roadMap.putIfAbsent(road[0], new ArrayList<>());
            roadMap.get(road[0]).add(new int[]{road[1], road[2]});
            roadMap.putIfAbsent(road[1], new ArrayList<>());
            roadMap.get(road[1]).add(new int[] {road[0], road[2]});

            // weightMap.put(road[0]+","+road[1], road[2]);
            // weightMap.put(road[1]+","+road[0], road[2]);
        }

        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(1);
        int[] visited = new int[n+1];
        int result = Integer.MAX_VALUE;

        while(!bfs.isEmpty()) {
            int node = bfs.poll();

            if(visited[node] != 1) {
                for(int[] child : roadMap.get(node)) {
                    visited[node] = 1;
                    result = Math.min(result, child[1]);
                    bfs.add(child[0]);
                }
            }
        }

        return result;
    }
}
