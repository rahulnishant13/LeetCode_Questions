// 2685. Count the Number of Complete Components
// https://leetcode.com/problems/count-the-number-of-complete-components/

class CounttheNumberofCompleteComponents {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                List<Integer> comp = new ArrayList<>();
                comp.add(i);
                dfs(i, graph, visited, comp);

                // System.out.println(comp);
                result += checkIfComplete(graph, comp);
            }
        }

        return result;
    }

    int checkIfComplete(Map<Integer, List<Integer>> graph, List<Integer> comp){
        for(int i=0; i<comp.size(); i++) {
            for(int j=i+1; j<comp.size(); j++) {
                if(!graph.get(comp.get(i)).contains(comp.get(j))){
                    return 0;
                }
            }
        }

        return 1;
    }

    void dfs(int i, Map<Integer, List<Integer>> graph, boolean[] visited, List<Integer> comp) {
        if(graph.containsKey(i)){
            for(int node : graph.get(i)) {
                if(!visited[node]) {
                    visited[node] = true;
                    comp.add(node);
                    dfs(node, graph, visited, comp);
                }
            }
        }
    }
}
