class Solution {
    public int maxMoves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int [][]dp=new int[n+1][m+1];

        for(int []row:dp){
            Arrays.fill(row,-1);
        }

        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,solve(grid,n,m,i,0,dp));
        }
        return max;
    }

    private static int solve(int [][]grid, int n,int m,int i,int j,int [][]dp){

        if(i>=n || j>=m) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int up=0;
        if(i-1>=0 && j+1<m && grid[i][j]<grid[i-1][j+1]){

            up=1+solve(grid,n,m,i-1,j+1,dp);
        }

        int down=0;
        if(i+1<n && j+1<m && grid[i][j]<grid[i+1][j+1]){

            down=1+solve(grid,n,m,i+1,j+1,dp);
        }

        int same=0;
        if(j+1<m && grid[i][j]<grid[i][j+1]){

            same=1+solve(grid,n,m,i,j+1,dp);
        }

        return dp[i][j]=Math.max(same,Math.max(up,down));
    }
}