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
    int find (int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    void union(int x, int y){
        int rootA = find(x);
        int rootB = find(y);
        if(rootA==rootB){
            return;
        }
        if(size[rootA]<size[rootB]){
            int t = rootA;
            rootA = rootB;
            rootB = t;
        }
        parent[rootB]=rootA;
        size[rootA]+=size[rootB];
    }
}

class Solution {
    List<List<Integer>> graph;
    boolean[] vis;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
             int n = accounts.size();
        DSU dsu = new DSU(n);
     Map<String, Integer> map = new HashMap<>();

     for(int i = 0;i<n;i++){
        for(int j = 1;j<accounts.get(i).size();j++){
            String em= accounts.get(i).get(j);
            if(map.containsKey(em)){
                dsu.union(i,map.get(em));
            }
            else{
                map.put(em,i);
            }
        }
     }   
     Map<Integer,TreeSet<String>> grp= new HashMap<>();
     for(String em:map.keySet()){
        int root=dsu.find(map.get(em));
        grp.putIfAbsent(root,new TreeSet<>());
        grp.get(root).add(em);
     }
     List<List<String>> ans = new ArrayList<>();
     for(int root : grp.keySet()){
        List<String> merged = new ArrayList<>();
        merged.add(accounts.get(root).get(0));
        merged.addAll(grp.get(root));
        ans.add(merged);
     }
     return ans;
    }
}