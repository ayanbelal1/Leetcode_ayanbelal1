class Solution {
    int MOD=1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        long [][]dp=new long[n+1][target+1];

        dp[0][0]=1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                long ways=0;
                for(int x=1;x<=k;x++){
                    ways=(j-x<0)?ways:ways+dp[i-1][j-x];
                }
                dp[i][j]=(ways)%MOD;
            }
        }
        return (int)dp[n][target];
    }
}