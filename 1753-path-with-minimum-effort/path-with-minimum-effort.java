class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int[] row:dist){
        Arrays.fill(row,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->a[0]-b[0]);
            pq.add(new int[]{0,0,0});
            dist[0][0]=0;

            int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                int effort=cur[0];
                int r = cur[1];
                int c = cur[2];

                if(r==n-1 && c==m-1){
                    return effort;
                }
                for(int[] d:dir){
                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr>=0 && nc>=0 && nr<n&&nc<m){
                        int neweffort=Math.max(effort,Math.abs(heights[r][c]-heights[nr][nc]));
                        if(neweffort<dist[nr][nc]){
                            dist[nr][nc]=neweffort;
                            pq.add(new int[]{neweffort,nr,nc});
                        }
                    }
                }
            }
            return 0;
    }
    
}