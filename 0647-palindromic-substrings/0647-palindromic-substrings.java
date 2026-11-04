class Solution {
    int n;
    Boolean [][]dp;

    public int countSubstrings(String s) {
        n=s.length();

        dp=new Boolean[n][n];

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(i,j,s)){
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean solve(int i,int j,String s){

        if(i>j) return true;;
        
        if(dp[i][j]!=null) return dp[i][j];

        char ch1=s.charAt(i);
        char ch2=s.charAt(j);

        boolean ans;
        if(ch1==ch2){
            ans=solve(i+1,j-1,s);
        }
        else ans=false;
        return dp[i][j]=ans;
    }
}