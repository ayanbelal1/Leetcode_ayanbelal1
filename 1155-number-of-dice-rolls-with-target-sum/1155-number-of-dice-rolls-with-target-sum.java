class Solution {
    long [][]dp;
    int MOD=1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        dp=new long [n+1][target+1];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return (int)solve(n,k,target);
    }

    private long solve(int n,int k,int target){
        
        if(n==0) return target==0?1:0;

        if(target<0) return 0;

        if(dp[n][target]!=-1) return dp[n][target];

        long sum=0;
        for(int i=1;i<=k;i++){
            sum+=solve(n-1,k,target-i);
        }
        return dp[n][target]=(sum)%MOD;
    }
}