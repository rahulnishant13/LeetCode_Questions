// 2503. Maximum Number of Points From Grid Queries
// https://leetcode.com/problems/maximum-number-of-points-from-grid-queries

class MaximumNumberOfPointsFromGridQueries {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int q = queries.length;
        int[][] query = new int[q][2];
        int[] result = new int[q];

        for(int i=0; i<q; i++){
            query[i][0] = queries[i];
            query[i][1] = i;
        }

        Arrays.sort(query, Comparator.comparingInt(a -> a[0]));
        boolean[][] visit = new boolean[grid.length][grid[0].length];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true;
        int count = 0;

        for(int[] qe : query) {
            int num = qe[0];
            int index = qe[1];

            while(!pq.isEmpty() && (num > pq.peek()[0])) {
                int[] node = pq.poll();
                int l = node[1];
                int r = node[2];
                count++;
                int[][] neighbours = {{l+1, r}, {l-1, r}, {l, r+1}, {l, r-1}};

                for(int[] neigh : neighbours) {
                    int nl = neigh[0];
                    int nr = neigh[1];
                    if(nr>=0 && nr<grid[0].length && nl>=0 && nl<grid.length && !visit[nl][nr]) {
                        pq.offer(new int[]{grid[nl][nr], nl, nr});
                        visit[nl][nr] = true;
                    }
                }
            }

            result[index] = count;
        }

        return result;
    }
}
