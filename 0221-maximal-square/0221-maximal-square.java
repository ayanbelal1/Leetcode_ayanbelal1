class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int [][]dp=new int[n][m];

        int max=Integer.MIN_VALUE;


        for(int r=0;r<n;r++){
            dp[r][0]=matrix[r][0]=='1'?1:0;
            max=Math.max(max,dp[r][0]);
        }
        for(int r=0;r<m;r++){
            dp[0][r]=matrix[0][r]=='1'?1:0;
            max=Math.max(max,dp[0][r]);
        }

        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){

                

                if(matrix[i][j]=='1'){
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}