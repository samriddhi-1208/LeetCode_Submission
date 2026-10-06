class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        for(int i = 0;i<r;i++){
            dfs(board,i,0);
            dfs(board,i,c-1);
        }
        for(int j =0;j<c;j++){
            dfs(board,0,j);
            dfs(board,r-1,j);
        }
        for(int i = 0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    void dfs(char[][] board,int r,int c){
        int row = board.length;
        int col = board[0].length;

        if(r<0 || r>=row || c<0 ||c>=col||board[r][c]!='O'){
            return;
        }
        board[r][c]='#';
        dfs(board,r+1,c);
        dfs(board,r-1,c);
        dfs(board,r,c+1);
        dfs(board,r,c-1);
    }
}