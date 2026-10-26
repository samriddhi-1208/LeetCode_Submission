class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int r = 0 ;r<9;r++){
            for(int c = 0;c<9;c++){
                if(board[r][c]=='.') continue;

                if(!isValid(board,r,c))return false;
            }
        }
        return true;
    }
    public boolean isValid(char[][] board,int r,int c){
        //check row
        for(int j = 0;j<9;j++){
            if(j!=c && board[r][j]==board[r][c])return false;
        }
        //check column
        for(int i = 0;i<9;i++){
            if(i!=r && board[i][c]==board[r][c])return false;
        }
        int startR = (r/3)*3;
        int startC = (c/3)*3;

        for(int i = startR;i<startR+3;i++){
            for(int j=startC;j<startC+3;j++){
                if((i!=r || j!=c) && board[i][j]==board[r][c]) return false;
            }
        }
        return true;
    }
}