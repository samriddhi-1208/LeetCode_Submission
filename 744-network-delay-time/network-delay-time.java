// class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         List<List<int[]>> adj = new ArrayList<>();
//         for(int i = 0;i<=n;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int[] t:times){
//             adj.get(t[0]).add(new int[]{t[1],t[2]});
//         }

//         int[] dist = new int[n+1];
//         Arrays.fill(dist,Integer.MAX_VALUE);
//         dist[k]=0;

//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//             (a,b)->a[0]-b[0]
//         );
//         pq.add(new int[]{0,k});

//         while(!pq.isEmpty()){
//             int[] cur = pq.poll();
//             int d= cur[0];
//             int u = cur[1];
//             if(d>dist[u])continue;
//             for(int[] e:adj.get(u)){
//                 int v = e[0],w=e[1];
//                 if(dist[v]>d+w){
//                     dist[v]=d+w;
//                     pq.add(new int[]{dist[v],v});}
//                 }
//             }
//             int ans=0;
//             for(int i = 1;i<=n;i++){
//                 if(dist[i]==Integer.MAX_VALUE) return -1;
//                 ans = Math.max(ans,dist[i]);
//             }
        
        
        
//      return ans;   
//     }
// }
class Solution{
    public int networkDelayTime(int[][] times,int n,int k){
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t : times){
            int u = t[0];
            int v = t[1];
            int w= t[2];
            adj.get(u).add(new int[]{v,w});
            
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        dist[k]=0;
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] curr= pq.poll();
            int u = curr[0];
            int d = curr[1];
            if(d>dist[u])continue;
            for(int [] edge:adj.get(u)){
                int next = edge[0];
                int weight = edge[1];
                if(d+weight<dist[next]){
                    dist[next]= d+weight;
                    pq.add(new int[]{next,dist[next]});
                }
            }
        }
        int ans = 0;
        for(int i = 1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            ans=Math.max(ans,dist[i]);
        }
        return ans;
    }
}