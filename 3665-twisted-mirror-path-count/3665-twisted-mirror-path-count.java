class Solution {
    int n;
    int m;
    int [][][]dp;
    int MOD=1000000007;

    public int uniquePaths(int[][] grid) {
        n=grid.length;
        m=grid[0].length;

        dp=new int [n][m][3];
        for(int [][]rows:dp){
            for(int []row:rows){
                Arrays.fill(row,-1);
            }
        }

        return solve(grid,0,0,2);
    }

    private int solve(int [][]grid,int i,int j,int prev){

        if(i>=n || j>=m) return 0;

        if(i==n-1 && j==m-1) return 1;

        if(dp[i][j][prev]!=-1) return dp[i][j][prev];

        int right=0;
        int down=0;
        if(grid[i][j]==1){
            if(prev==0){
                return dp[i][j][prev]=solve(grid,i+1,j,1);
            }
            else if(prev==1){
                return dp[i][j][prev]=solve(grid,i,j+1,0);
            }
        }

        right=solve(grid,i,j+1,0);
        down=solve(grid,i+1,j,1);

        return dp[i][j][prev]=(right+down)%MOD;
    }
}