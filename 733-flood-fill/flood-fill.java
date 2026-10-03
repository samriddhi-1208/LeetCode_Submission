class Solution {
    int[] dr={-1,1,0,0};
    int[] dc={0,0,-1,1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
     int oldColor = image[sr][sc];
if (oldColor == color)return image;
help(image, sr, sc, oldColor, color);
return image;
    }
    public void help(int[][] image,int r,int c,int oldcolor,int newcol){
if(r<0 || c<0 || r>=image.length || c>=image[0].length){
    return;
}
if(image[r][c]!=oldcolor){
    return;
}
image[r][c]=newcol;
for(int i = 0;i<4;i++){
    help(image,r+dr[i],c+dc[i],oldcolor,newcol);
}
    }
}