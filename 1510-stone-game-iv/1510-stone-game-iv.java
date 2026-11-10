class Solution {
    Boolean[][] dp;

    public boolean winnerSquareGame(int n) {

        dp = new Boolean[n+1][2];
        return solve(n, 1);
    }

    private boolean solve(int n, int state) {

        if(n==0) return false;

        if(dp[n][state]!=null) return dp[n][state];

        boolean ans=false;
        int i=1;

        while(i*i<=n) {

            if(state==1 && !solve(n-(i*i),0)) {
                ans = true;
                break;
            }
            else if(state==0 && !solve(n-(i*i),1)) {
                ans=true;
                break;
            }

            i++;
        }

        return dp[n][state]=ans;
    }
}