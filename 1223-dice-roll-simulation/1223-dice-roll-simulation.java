class Solution {
    int []rollmax;
    long [][][]dp;
    static final int MOD=(int)1e9+7;

    public int dieSimulator(int n, int[] rollMax) {
        rollmax=rollMax;

        int max=(int)-1e9;
        for(int x:rollmax){
            max=Math.max(max,x);
        }

        dp=new long[n+1][max+1][7];
        for(long [][]rows:dp){
            for(long []row:rows){
                Arrays.fill(row,-1);
            }
        }

        return (int)solve(n,0,0);
    }

    private long solve(int n,int kMax,int idx){

        if(n==0) return 1;

        if(dp[n][kMax][idx]!=-1) return dp[n][kMax][idx];

        long count=0;
        for(int k=1;k<=6;k++){
            int newMax;
            if(idx==k){
                newMax=kMax+1;
            }
            else newMax=1;

            if(rollmax[k-1]>=newMax){
                count+=(solve(n-1,newMax,k))%MOD;
            }
        }
        return dp[n][kMax][idx]=(count)%MOD;
    }
}