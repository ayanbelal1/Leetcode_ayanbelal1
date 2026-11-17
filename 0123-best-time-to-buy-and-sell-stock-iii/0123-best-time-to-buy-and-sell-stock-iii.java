class Solution {
    int n;
    int []prices;
    int [][][]dp;
    public int maxProfit(int[] prices) {
        n=prices.length;
        this.prices=prices;

        dp=new int[n+1][2][3];
        for(int [][]rows:dp){
            for(int []row:rows){
                Arrays.fill(row,-1);
            }
        }

        return solve(0,1,2);
    }

    private int solve(int i,int bought,int limit){

        if(i==n || limit==0) return 0;

        if(dp[i][bought][limit]!=-1) return dp[i][bought][limit];

        if(bought==1){

            int buy=solve(i+1,0,limit)-prices[i];

            int skipBuy=solve(i+1,bought,limit);

            return dp[i][bought][limit]=Math.max(buy,skipBuy);
        }
        else{

            int sell=solve(i+1,1,limit-1)+prices[i];

            int skipSell=solve(i+1,bought,limit);
            
            return  dp[i][bought][limit]=Math.max(sell,skipSell);
        }
    }
}