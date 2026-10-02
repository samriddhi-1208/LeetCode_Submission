class Solution {
    public void setZeroes(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
// int row[] = new int[m];
// int col[] = new int[n];
// for(int i = 0;i<m;i++){
//     for(int j = 0;j<n;j++){
//         if(matrix[i][j]==0){
//             row[i]=1;
//             col[j]=1;
//         }
//     }
// }
// for(int i = 0;i<m;i++){
//     for(int j = 0;j<n;j++){
//         if(row[i]==1 || col[j]==1){
//             matrix[i][j]=0;
//         }
//     }
// }
int m = matrix.length;
int n = matrix[0].length;
int[][] dup = new int[m][n];
for(int i = 0;i<m;i++){
    for(int j = 0;j<n;j++){
        dup[i][j]=matrix[i][j];
    }
}
for(int i = 0;i<m;i++){
    for(int j = 0;j<n;j++){
        if(matrix[i][j]==0 && dup[i][j]==0){
            for(int x = 0;x<n;x++){
                matrix[i][x]=0;
            }
            for(int y = 0;y<m;y++){
                matrix[y][j]=0;
            }
        }
    }
}
    }
}