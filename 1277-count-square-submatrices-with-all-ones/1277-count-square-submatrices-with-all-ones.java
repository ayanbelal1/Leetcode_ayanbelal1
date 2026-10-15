class Solution {
    public int countSquares(int[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;

        int [][]dp=new int[n][m];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }

        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                sum+=solve(matrix,i,j,dp);
            }
        }
        return sum;
    }

    private static int solve(int [][]matrix,int i,int j,int [][]dp){

        int n=matrix.length;
        int m=matrix[0].length;

        if(i>=n) return 0;

        if(j>=m) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(matrix[i][j]==0) return 0;

        
        int right=solve(matrix,i,j+1,dp);
        int down=solve(matrix,i+1,j,dp);
        int diagonal=solve(matrix,i+1,j+1,dp);

        return dp[i][j]=1+Math.min(right,Math.min(down,diagonal));
    }
}