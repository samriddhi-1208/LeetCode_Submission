class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        dfs(0,rooms,vis);
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }
    void dfs(int r,List<List<Integer>> rooms,boolean[] vis){
        vis[r]=true;
        for(int k : rooms.get(r)){
            if(!vis[k]){
                dfs(k,rooms,vis);
            }
        }
    }
}