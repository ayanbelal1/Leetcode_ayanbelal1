class Solution {
    int n;
    int []prices;
    int [][]dp;
    public int maxProfit(int[] prices) {
        n=prices.length;
        this.prices=prices;

        dp=new int[n+1][2];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        

        return solve(0,1);
    }

    private int solve(int i,int bought){

        if(i>=n) return 0;

        if(dp[i][bought]!=-1) return dp[i][bought];

        if(bought==1){

            int buy=solve(i+1,0)-prices[i];

            int skipBuy=solve(i+1,bought);

            return dp[i][bought]=Math.max(buy,skipBuy);
        }
        else{

            int sell=solve(i+2,1)+prices[i];

            int skipSell=solve(i+1,bought);
            
            return  dp[i][bought]=Math.max(sell,skipSell);
        }
    }
}