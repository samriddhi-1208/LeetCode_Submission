class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] ind = new int[numCourses];
        for(int[] p:prerequisites){
            int course = p[0];
            int pre = p[1];
            adj.get(pre).add(course);
            ind[course]++;
        }
Queue<Integer> q = new LinkedList<>();
for(int i = 0;i<numCourses;i++){
    if(ind[i]==0){
        q.offer(i);
    }
}
int count = 0;
while(!q.isEmpty()){
    int curr=q.poll();
    count++;
    for(int next : adj.get(curr)){
ind[next]--;
if(ind[next]==0){
q.offer(next);
}
    }
}
return count==numCourses;
    }
}