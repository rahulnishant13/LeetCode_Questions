// 1514. Path with Maximum Probability
// https://leetcode.com/problems/path-with-maximum-probability/description/

class PathwithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        double[] res = new double[n];
        Arrays.fill(res, Double.MIN_VALUE);
        int i = 0;

        for(int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashMap<>());
            graph.get(edge[0]).put(edge[1], succProb[i]);

            graph.putIfAbsent(edge[1], new HashMap<>());
            graph.get(edge[1]).put(edge[0], succProb[i]);
            i++;
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));

        pq.offer(new double[]{start_node, 1.0});
        res[start_node] = 1.0;

        while(!pq.isEmpty()) {
            double[] pair = pq.poll();
            int node = (int) pair[0];

            if(graph.containsKey(node)) {
                for(Map.Entry<Integer, Double> adj : graph.get(node).entrySet()) {
                    if(res[adj.getKey()] == Double.MIN_VALUE || res[adj.getKey()] < (adj.getValue() * pair[1])) {
                        res[adj.getKey()] = adj.getValue() * pair[1];
                        pq.offer(new double[]{adj.getKey(), res[adj.getKey()]});
                    }
                }
            }
        }

        // System.out.println(Arrays.toString(res));

        return res[end_node] == Double.MAX_VALUE ? 0 : res[end_node];
    }
}
