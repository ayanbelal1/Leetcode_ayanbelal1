class Solution {
    int n;
    int m;
    int [][][]dp;
    int MOD=1000000007;

    public int uniquePaths(int[][] grid) {
        n=grid.length;
        m=grid[0].length;

        dp=new int [n][m][2];

        dp[0][0][0]=1;
        for(int i=1;i<n;i++){
            dp[i][0][1]=1;
            if(grid[i][0]==1) break;
        }
        for(int i=1;i<m;i++){
            dp[0][i][0]=1;
            if(grid[0][i]==1) break;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){

                if(grid[i][j-1]==1){
                    dp[i][j][0]=dp[i][j-1][1];
                }
                else{
                    dp[i][j][0]=(dp[i][j-1][0]+dp[i][j-1][1])%MOD;
                }

                if(grid[i-1][j]==1){
                    dp[i][j][1]=dp[i-1][j][0];
                }
                else{
                    dp[i][j][1]=(dp[i-1][j][1]+dp[i-1][j][0])%MOD;
                }
            }
        }
        return (dp[n-1][m-1][1]+dp[n-1][m-1][0])%MOD;
    }
}