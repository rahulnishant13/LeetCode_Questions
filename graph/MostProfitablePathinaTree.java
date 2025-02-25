// 2467. Most Profitable Path in a Tree
// https://leetcode.com/problems/most-profitable-path-in-a-tree/

class MostProfitablePathinaTree {
    Map<Integer, List<Integer>> edgeMap;
    Map<Integer, Integer> bobPath;
    boolean[] visited;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        edgeMap = new HashMap<>();
        bobPath = new HashMap<>();
        visited = new boolean[amount.length];

        Arrays.fill(visited, false);

        for(int[] edge : edges){
            edgeMap.putIfAbsent(edge[0], new ArrayList<>());
            edgeMap.putIfAbsent(edge[1], new ArrayList<>());
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }

        findBobPath(bob, 0);
        Arrays.fill(visited, false);
        findAlicePath(0, amount, 0, 0);

        return max;
    }

    int max = Integer.MIN_VALUE;
    // int curr = 0; 

    void findAlicePath(int alice, int[] amount, int steps, int curr) {    
        visited[alice] = true;
        int bobStep = bobPath.getOrDefault(alice, -1);
        if(bobStep == steps){
            curr += amount[alice]/2;
        }else if(bobStep == -1 || bobStep > steps){
            curr += amount[alice];
        }

        if(alice != 0 && edgeMap.get(alice).size() < 2){
            max = Math.max(max, curr);
            // curr = 0;
            // return;
        }

        for(int node : edgeMap.get(alice)){
            if(!visited[node]) {
                findAlicePath(node, amount, steps+1, curr);
                // max = Math.max(val, max);
            }
        }

        // return;
    }

    boolean findBobPath(int bob, int steps){
        bobPath.put(bob, steps);
        visited[bob] = true;

        if(bob == 0){
            return true;
        }

        for(int node : edgeMap.get(bob)){
            if(!visited[node]) {
               if(findBobPath(node, steps+1)){
                return true;
               }
            }
        }

        bobPath.remove(bob);
        return false;
    }
}
