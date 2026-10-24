class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        parent = new int[n];
        size=new int[n];
        for(int i =0;i<n;i++){
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

    boolean union(int x ,int y){
        int rootA = find(x);
        int rootB = find(y);
        if(rootA==rootB){
            return false;
        }
        if(size[rootA]<size[rootB]){
            int t=rootA;
            rootA=rootB;
            rootB = t;
        }
        parent[rootB]=rootA;
        size[rootA]+=size[rootB];

        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu= new DSU(n);
        List<int[]> edges = new ArrayList<>();
        //generate all the possible the edges
        for(int i = 0;i<n;i++){
for(int j =i+1;j<n;j++){
    int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
    edges.add(new int[]{dist,i,j});
}
        }
        edges.sort((a,b)->Integer.compare(a[0],b[0]));
        int totCost=0;
        int edgeC=0;
        for(int[] e:edges){
            int cost = e[0];
            int u=e[1];
            int v = e[2];
            if(dsu.union(u,v)){
                totCost+=cost;
               edgeC++;

                if(edgeC==n-1){
                    break;
                }
            }
        }
        return totCost;
    }
}