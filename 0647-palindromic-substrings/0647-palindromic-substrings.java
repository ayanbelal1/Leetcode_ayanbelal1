class Solution {
    int n;
    boolean [][]dp;

    public int countSubstrings(String s) {
        n=s.length();

        dp=new boolean[n][n];

        int ans=0;
        for(int len=1;len<=n;len++){
            for(int i=0;i+len-1<n;i++){
                
                int j=len+i-1;

                char ch1=s.charAt(i);
                char ch2=s.charAt(j);

                if(i==j) dp[i][j]=true;

                else if(i+1==j){
                    dp[i][j]=(ch1==ch2);
                }
                else{
                    if(ch1==ch2){
                        dp[i][j]=dp[i+1][j-1];
                    }
                    else{
                        dp[i][j]=false;
                    }
                }

                if(dp[i][j]) ans++;

            }
        }
        return ans;
    }
}