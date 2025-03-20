// 3108. Minimum Cost Walk in Weighted Graph
// https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/

class MinimumCostWalkinWeightedGraph {
    int[] parent;
    int[] rank;

    int findParent(int data) {
        while(data != parent[data]) {
            parent[data] = parent[parent[data]];
            data = parent[data];
        }

        return data;

        // if(data == parent[data]) {
        //     return data;
        // }

        // return findParent(parent[data]);
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            int p1 = findParent(edge[0]);
            int p2 = findParent(edge[1]);

            if(p1 == p2) {
                continue;
            }

            if(rank[p2] > rank[p1]) {
                parent[p1] = p2;
                rank[p2] += rank[p1];
            } else {
                parent[p2] = p1;
                rank[p1] += rank[p2];
            }

            // if(rank[p1] > rank[p2]) {
            //     parent[p2] = p1;
            //     rank[p1] += rank[p2];
            // } else {
            //     parent[p1] = p2;
            //     rank[p2] += rank[p1];
            // }
            // System.out.println("parent : " + Arrays.toString(parent));
            // System.out.println("rank  :  " + Arrays.toString(rank));
        }

        Map<Integer, Integer> resultMap = new HashMap<>();
        for(int[] edge : edges) {
            int superParent = findParent(edge[0]);
            if(resultMap.containsKey(superParent)) {
                resultMap.put(superParent, resultMap.get(superParent) & edge[2]);
            } else {
                resultMap.put(superParent, edge[2]);
            }
        }

        // System.out.println(Arrays.toString(parent));
        // System.out.println(Arrays.toString(rank));
        int[] res = new int[query.length];
        int i=0;
        for(int[] que : query) {
            if(findParent(que[0]) != findParent(que[1])) {
                res[i++] = -1;
            } else {
                res[i++] = resultMap.get(findParent(que[0]));
            }
        }

        return res;
    }
}
