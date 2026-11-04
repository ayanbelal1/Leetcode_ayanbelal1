class Solution {
    int n;
    int []dp;
    boolean [][]check;

    public int minCut(String s) {
        n=s.length();
        dp=new int [n];
        Arrays.fill(dp,-1);
        checkPalindrome(s);

        return solve(n-1);
    }

    private int solve(int i){

        if (check[0][i]) return dp[i] = 0;

        if(dp[i]!=-1) return dp[i];

        int ans=(int)1e9;
        for(int k=0;k<i;k++){

            if(check[k+1][i]){
                int cost=1+solve(k);
                ans=Math.min(ans,cost);
            }
        }
        return dp[i]=ans;
    }

    private void checkPalindrome(String s){
        
        check=new boolean[n][n];
        for(int len=1;len<=n;len++){
            for(int i=0;i+len-1<n;i++){
                int j=i+len-1;

                char ch1=s.charAt(i);
                char ch2=s.charAt(j);

                if(i==j){
                    check[i][j]=true;
                }

                else if(i+1==j){
                    check[i][j]=(ch1==ch2);
                }
                else{
                    check[i][j]=(ch1==ch2 && check[i+1][j-1]);
                }
            }
        }
    }
}