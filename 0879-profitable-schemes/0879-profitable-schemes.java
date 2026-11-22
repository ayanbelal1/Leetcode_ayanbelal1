class Solution {
    int m;
    int []group;
    int []profit;
    int [][][]dp;
    static final int MOD = 1000000007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        m=profit.length;
        this.group=group;
        this.profit=profit;
        
        dp=new int [m+1][n+1][minProfit+1];
        for(int [][]rows:dp){
            for(int []row:rows){
                Arrays.fill(row,-1);
            }
        }

        return solve(0,n,minProfit);
    }

    private int solve(int i,int n,int minProfit){

        if(i>=m && minProfit<=0 && n>=0) return 1;
        
        if(i>=m && minProfit>0 || minProfit>0 && n<=0) return 0;

        if(dp[i][n][minProfit]!=-1) return dp[i][n][minProfit];

        int skip=solve(i+1,n,minProfit);

        int pick=0;
        if(group[i]<=n){
            pick=solve(i+1,n-group[i],Math.max(0, minProfit-profit[i]));
        }

        return dp[i][n][minProfit]=(skip+pick)%MOD;
    }
}