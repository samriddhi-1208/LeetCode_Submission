class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        parent = new int[n+1];
        size= new int[n+1];
        for(int i = 0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    boolean union(int x,int y){
        int rootA = find(x);
        int rootB = find(y);
        if(rootA==rootB){
            return false;
        }
        if(size[rootA]<size[rootB]){
            int temp = rootA;
            rootA =rootB;
            rootB = temp;
        }
        parent[rootB]=rootA;
        size[rootA]+=size[rootB];
        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
//      int n = edges.length;
//      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//      for(int i = 0;i<=n;i++){
//         adj.add(new ArrayList<>());
//      }   
//      for(int[] e : edges){
//         int u = e[0];
//         int v = e[1];

//         boolean[] vis = new boolean[n+1];
//         if(dfs(u,v,adj,vis)){
//             return e;
//         }
//         adj.get(u).add(v);
//         adj.get(v).add(u);
//      }
//      return new int[0];
//     }
//     boolean dfs(int node, int target,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
//         if(node == target){
//             return true;
//         }
//         vis[node]=true;
//         for(int neigh: adj.get(node)){
// if(!vis[neigh]){
//     if(dfs(neigh, target,adj,vis)){
//         return true;
//     }
// }
//         }
//         return false;
int n = edges.length;
DSU dsu= new DSU(n);
for(int[] e:edges){
    int u =e[0];
    int v = e[1];
    if(!dsu.union(u,v)){
        return e;
    }
}
return new int[0];

    }
}