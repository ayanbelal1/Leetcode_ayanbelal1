class Solution {
    int [][]dp;
    public int getMoneyAmount(int n) {
        
        dp=new int[n+1][n+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }

        return solve(1,n);
    }

    private int solve(int i,int j){
        
        if(i>=j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int ans=(int)1e9;
        for(int k=i;k<=j;k++){
            int cost=Math.max(solve(i,k-1),solve(k+1,j))+k;
            ans=Math.min(ans,cost);
        }
        return dp[i][j]=ans;
    }
}