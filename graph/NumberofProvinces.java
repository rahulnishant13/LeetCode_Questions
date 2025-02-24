// 547. Number of Provinces
// https://leetcode.com/problems/number-of-provinces/

class NumberofProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int result = 0;
        int[] visited = new int[n];
        
        for(int i=0; i<n; i++){
            if(visited[i] != 1){
                result++;
                bfs(i, isConnected, visited);
            }
        }
        return result;
    }

    void bfs(int node, int[][] isConnected, int[] visited){
        visited[node] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i=0; i<isConnected.length; i++){
                if(visited[i] != 1 && isConnected[curr][i] == 1){
                    visited[i] = 1;
                    queue.offer(i);
                }
            }
        }
    }
}
