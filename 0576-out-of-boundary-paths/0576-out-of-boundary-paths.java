class Solution {
    // int dr={-1,0,1,0};
    // int dc={0,-1,0,1};
    int MOD=1000000007;

    int [][][]dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        dp=new int[m][n][maxMove+1];
        for(int [][]rows:dp){
            for(int []row:rows){
                Arrays.fill(row,-1);
            }
        }

        return path(m,n,maxMove,startRow,startColumn);
    }

    public int path(int n,int m,int maxMove,int i,int j){

        if(i>=n || j>=m || i<0 || j<0) return 1;

        if(maxMove==0){
            return 0;
        }

        if(dp[i][j][maxMove]!=-1) return dp[i][j][maxMove];

        int up=path(n,m,maxMove-1,i-1,j);

        int down=path(n,m,maxMove-1,i+1,j);

        int back=path(n,m,maxMove-1,i,j-1);

        int forward=path(n,m,maxMove-1,i,j+1);

        return dp[i][j][maxMove]=(int)(((long) up+down+back+forward)%MOD);
    }
}