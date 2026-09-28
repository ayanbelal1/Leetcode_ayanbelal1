class Solution {
    public boolean isSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();

        int [][]dp=new int [2][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(t.charAt(i-1)==s.charAt(j-1)){
                    dp[1][j]=1+dp[0][j-1];
                }
                else{
                    dp[1][j]=Math.max(dp[0][j],dp[1][j-1]);
                }
            }
            for(int x=0;x<=m;x++){
                dp[0][x]=dp[1][x];
            }
        }
        return dp[1][m]==s.length();
    }
}