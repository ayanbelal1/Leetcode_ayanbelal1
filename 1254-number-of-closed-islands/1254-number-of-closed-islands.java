class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j] == 0 && check(grid,i,j,n,m)){

                    count++;
                }
            }
        }
        return count;
    }

    private boolean check(int [][]grid,int i,int j,int n,int m){

        if(i<0 || i>=n || j<0 || j>=m) return false;

        if(grid[i][j]==1) return true;

        grid[i][j]=1;

        boolean left=check(grid,i,j-1,n,m);
        boolean right=check(grid,i,j+1,n,m);
        boolean down=check(grid,i+1,j,n,m);
        boolean up=check(grid,i-1,j,n,m);

        return left&&right&&down&&up;
    }
}