// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for(int i = 0;i<numCourses;i++){
//             adj.add(new ArrayList<>());
//         }
//         int[] ind = new int[numCourses];
//         for(int[] p:prerequisites){
//             int course = p[0];
//             int pre = p[1];
//             adj.get(pre).add(course);
//             ind[course]++;
//         }
// Queue<Integer> q = new LinkedList<>();
// for(int i = 0;i<numCourses;i++){
//     if(ind[i]==0){
//         q.offer(i);
//     }
// }
// int count = 0;
// while(!q.isEmpty()){
//     int curr=q.poll();
//     count++;
//     for(int next : adj.get(curr)){
// ind[next]--;
// if(ind[next]==0){
// q.offer(next);
// }
//     }
// }
// return count==numCourses;



//     }
// }

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis, pathVis)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                int[] vis, int[] pathVis) {

        vis[node] = 1;
        pathVis[node] = 1;

        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {
                if (dfs(neighbor, adj, vis, pathVis)) {
                    return true;
                }
            } else if (pathVis[neighbor] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }
}
