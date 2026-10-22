class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // List<List<int[]>> adj = new ArrayList<>();
        // for(int i = 0;i<n;i++){
        //     adj.add(new ArrayList<>());
        // }
        // for(int[]e : edges){
        //     int u = e[0], v=e[1],w = e[2];
        //     adj.get(u).add(new int[]{v,w});
        //     adj.get(v).add(new int[]{u,w});
        // }
        // int rcity = -1;
        // int minReach = n+1;
        // for(int src = 0;src<n;src++){
        //     long[] dist = new long[n];
        //     Arrays.fill(dist,Integer.MAX_VALUE);
        //     dist[src]=0;

        //     PriorityQueue<long[]> pq = new PriorityQueue<>(
        //         (a,b)-> Long.compare(a[0],b[0]));

        //        pq.add(new long[]{0, src});

        //         while(!pq.isEmpty()){
        //             long[] cur = pq.poll();
        //             long d = cur[0];
        //             int u = (int) cur[1];

        //             if(d>dist[u]) continue;

        //             for(int[] next: adj.get(u)){
        //                 int v = next[0];
        //                 long w = next[1];
        //                 if(dist[v]>d+w){
        //                     dist[v]=d+w;
        //                     pq.add(new long[]{dist[v],v});
        //             }
        //             }
        //         }
        //         int count = 0;
        //         for(int i = 0;i<n;i++){
        //             if(i!=src && dist[i]<=distanceThreshold)count++;
        //         }
        //         if(count<=minReach){
        //             minReach = count;
        //             rcity = src;
        //         }
        //     }         
        // return rcity;

        int[][] dist = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i==j){
                    dist[i][i]=0;
                }
                else{
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for(int[] e : edges){
            int u = e[0];
            int v=e[1];
            int w = e[2];
            dist[u][v]=w;
            dist[v][u]=w;
        }
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        int res =-1;
        int minCount=Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            int count = 0;
            for(int j = 0;j<n;j++){
                if(i!=j && dist[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=minCount){
                minCount=count;
                res=i;
            }
        }
        return res;
    }
    }
