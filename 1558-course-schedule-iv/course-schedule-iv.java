class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] r= new boolean[n][n];
       for(int[] p: prerequisites){
           r[p[0]][p[1]] = true;
       } 
      for(int k = 0;k<n;k++){
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                if(r[i][k] && r[k][j]){
                    r[i][j]=true;
                }
            }
        }
      } 
      List<Boolean> ans = new ArrayList<>();
      for(int[] q : queries){
        ans.add(r[q[0]][q[1]]);
      }
      return ans;
    }
}