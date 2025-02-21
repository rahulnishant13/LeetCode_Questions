// Find if Path Exists in Graph
// https://leetcode.com/problems/find-if-path-exists-in-graph/


class FindifPathExistsinGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n==1 && edges.length == 0){
            return true;
        }

        Map<Integer, List<Integer>> edgeMap = new HashMap<>();

        for(int[] edge : edges){
            if(!edgeMap.containsKey(edge[0])){
                edgeMap.put(edge[0], new ArrayList<>());
            }
            if(!edgeMap.containsKey(edge[1])){
                edgeMap.put(edge[1], new ArrayList<>());
            }
            List<Integer> list = edgeMap.get(edge[0]);
            list.add(edge[1]);

            list = edgeMap.get(edge[1]);
            list.add(edge[0]);
        }
        if(!edgeMap.containsKey(destination)){
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        return checkValidPath(source, destination, edgeMap, visited);
    }

    boolean checkValidPath(int source, int destination, Map<Integer, List<Integer>> edgeMap, Set<Integer> visited){
        if(source == destination){
            return true;
        }
        visited.add(source);

        List<Integer> list = edgeMap.getOrDefault(source, new ArrayList<>());
        // System.out.println(" : " + Arrays.toString(list.toArray()));
        for(int node : list){
            if(!visited.contains(node)){
                if(checkValidPath(node, destination, edgeMap, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
