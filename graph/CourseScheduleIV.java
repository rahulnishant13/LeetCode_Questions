// https://leetcode.com/problems/course-schedule-iv/description/
// 1462. Course Schedule IV

class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] degreeNum = new int[numCourses];
        Map<Integer, List<Integer>> preMap = new HashMap<>();

        for(int[] prerequisite : prerequisites) {
            preMap.putIfAbsent(prerequisite[0], new ArrayList<>());
            preMap.get(prerequisite[0]).add(prerequisite[1]);
            degreeNum[prerequisite[1]]++;
        }

        Queue<Integer> bfs = new LinkedList<>();
        Map<Integer, Set<Integer>> topoMap = new HashMap<>();

        for(int i=0; i<numCourses; i++){
            topoMap.put(i, new HashSet<>());
            if(degreeNum[i] == 0){
                bfs.add(i);
            }
        }

        // System.out.println("degreeMap : " + Arrays.toString(degreeNum));

        while(!bfs.isEmpty()) {
            int node = bfs.poll();
            
            if(preMap.containsKey(node)) {
                for(int child : preMap.get(node)){
                    topoMap.get(child).add(node);
                    topoMap.get(child).addAll(topoMap.get(node));
                    degreeNum[child]--;
                    if(degreeNum[child] == 0) {
                        bfs.add(child);
                    }
                }
            }
        }

        // System.out.println(" : " + Arrays.toString(topoList.toArray()));

        List<Boolean> result = new ArrayList<>();

        for(int[] query : queries) {
            if(topoMap.get(query[1]).contains(query[0])) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
