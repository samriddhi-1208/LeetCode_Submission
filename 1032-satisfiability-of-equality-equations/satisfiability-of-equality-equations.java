class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        parent = new int[n];
        size = new int[n];
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
        int rootB=find(y);
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
    public boolean equationsPossible(String[] equations) {
      DSU dsu = new DSU(26);
      for(String e: equations) {
        if(e.charAt(1)=='='){
            int a = e.charAt(0)-'a';
            int b = e.charAt(3)-'a';
            dsu.union(a,b);
        }
      }
      for(String e:equations){
        if(e.charAt(1)=='!'){
            int a = e.charAt(0)-'a';
            int b = e.charAt(3)-'a';
            if(dsu.find(a)==dsu.find(b)){
                return false;
            }
        }
      }
      return true; 
    }
}