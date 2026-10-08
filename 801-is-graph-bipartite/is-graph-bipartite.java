// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
//         int[] color=new int[n];
//         Arrays.fill(color,-1);
//         for(int i = 0;i<n;i++){
//             if(color[i]!=-1) continue;
//             Queue<Integer> q = new LinkedList<>();
//             q.add(i);
//             color[i]=0;
//             while(!q.isEmpty()){
//                 int node=q.poll();
//                 for(int next:graph[node]){
//                     if(color[next]== -1){
//                         color[next]=1-color[node];
//                         q.add(next);
//                     }
//                     else if(color[next]==color[node]){
//                         return false;
//                     }
//                 }
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for(int i = 0; i<n; i++){
            if(color[i] == -1){
                if(!dfs(i,1,color,graph)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, int col, int[] color, int[][] graph){
        color[node] = col;
        for(int nei : graph[node]){
            if(color[nei] == -1){
                if(!dfs(nei,1-col,color,graph)) return false;
           }else if(col == color[nei]) return false; 
        }
        return true;
    }
}