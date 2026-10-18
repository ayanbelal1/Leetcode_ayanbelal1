class Solution {
    public int nthUglyNumber(int n) {
        
        int []dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=1;

        int a=1,b=1,c=1;

        for(int i=2;i<=n;i++){
            int ab=dp[a]*2;
            int bb=dp[b]*3;
            int cb=dp[c]*5;

            dp[i]=Math.min(ab,Math.min(bb,cb));

            if (dp[i]==ab) a++;
            if (dp[i]==bb) b++;
            if (dp[i]==cb) c++;
        }
        return dp[n];
    }
}