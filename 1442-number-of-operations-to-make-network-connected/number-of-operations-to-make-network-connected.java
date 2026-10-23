class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        parent = new int[n];
        size= new int[n];

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
        if(rootA == rootB){
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
    public int makeConnected(int n, int[][] connections) {
      if(connections.length<n-1){
        return -1;
      }  
      DSU dsu = new DSU(n);
      int c=n;
      for(int[] e:connections){
        int u = e[0];
        int v = e[1];
        if(dsu.union(u,v)){
            c--;
        }
      }
      return c-1;
    }
}