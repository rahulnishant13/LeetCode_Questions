// 743. Network Delay Time
// https://leetcode.com/problems/network-delay-time/

class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // if(n == k) return -1;

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        int[] st = new int[n+1];
        Arrays.fill(st, Integer.MAX_VALUE);

        for(int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        PriorityQueue<int[]> dijkstra = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        dijkstra.add(new int[]{k, 0});
        st[k] = 0;

        while(!dijkstra.isEmpty()) {
            int[] node = dijkstra.poll();
            if(graph.containsKey(node[0])) {
                for(var entry : graph.get(node[0]).entrySet()) {
                    if(st[entry.getKey()] > (node[1] + entry.getValue())) {
                        st[entry.getKey()] = node[1] + entry.getValue();
                        dijkstra.add(new int[]{entry.getKey(), st[entry.getKey()]});
                    }
                }
            }
        }

        // System.out.println(Arrays.toString(st));

        int result = -1;
        for(int i=1; i<n+1; i++) {
            if(st[i] != Integer.MAX_VALUE) {
                result = Math.max(result, st[i]);
            } else {
                return -1;
            }
        }

        return result;
    }
}
