// 207. Course Schedule
// https://leetcode.com/problems/course-schedule/
class CourseSchedule {
    public boolean canFinish(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        int[] degree = new int[n];

        for(int[] cons : prerequisites) {
            courseMap.putIfAbsent(cons[1], new ArrayList<>());
            courseMap.get(cons[1]).add(cons[0]);
            degree[cons[0]]++;
        }

        Queue<Integer> topo = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(degree[i] == 0) {
                topo.offer(i);
            }
        }

        while(!topo.isEmpty()) {
            int node = topo.poll();
            result.add(node);

            if(courseMap.containsKey(node))
            for(int child : courseMap.get(node)) {
                degree[child]--;
                if(degree[child] == 0) {
                    topo.offer(child);
                }
            }
        }

        return result.size() == n;
    }
}
