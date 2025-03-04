// 210. Course Schedule II
// https://leetcode.com/problems/course-schedule-ii/

class CourseScheduleII {
    public int[] findOrder(int n, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[n];
        int[] degree = new int[n];
        
        for(int i=0; i<n; i++) {
            graph[i] = new LinkedList<Integer>();
        }

        for(int[] cond : prerequisites) {
            graph[cond[1]].add(cond[0]);
            degree[cond[0]]++;
        }

        Queue<Integer> topo = new LinkedList<>();

        for(int i=0; i<n; i++) {
            if(degree[i] == 0)
                topo.offer(i);
        }

        int[] result = new int[n];
        int k = 0;

        while(!topo.isEmpty()) {
            int node = topo.poll();
            result[k++] = node;

            if(!graph[node].isEmpty()) {
                for(int child : graph[node]) {
                    degree[child]--;
                    if(degree[child] == 0) {
                        topo.offer(child);
                    }
                }
            }
        }

        return k==n ? result : new int[0];

    }
}
