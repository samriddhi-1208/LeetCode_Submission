class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        parent = new int[n];
        size=new int[n];

        for(int i =0;i<n;i++){
            parent[i]=i;
            size[i]=i;
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
            rootA = rootB;
            rootB = temp;
        }
        parent[rootB]=rootA;
        size[rootA]+=size[rootB];

        return true;
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
    //     int n = isConnected.length;
    //     boolean[] vis = new boolean[n];
    //     int pro=0;

    //     for(int i = 0;i<n;i++){
    //         if(!vis[i]){
    //             pro++;
    //             dfs(i,isConnected,vis);
    //             }
    //     }
    //     return pro;
    // }
    // void dfs(int city,int[][] isConnected,boolean[] vis){
    //     vis[city]=true;
    //     for(int i = 0;i<isConnected.length;i++){
    //         if(isConnected[city][i]==1 && !vis[i]){
    //             dfs(i,isConnected,vis);
    //         }
    //     }
int n = isConnected.length;
DSU dsu= new DSU(n);
int provinces=n;
for(int i =0;i<n;i++){
    for(int j =i+1;j<n;j++){
        if(isConnected[i][j]==1){
            if(dsu.union(i,j)){
                provinces--;
            }
        }
    }
}
return provinces;

    }



}