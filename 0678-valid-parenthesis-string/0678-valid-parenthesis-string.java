class Solution {

    public boolean checkValidString(String s) {
        if(s.charAt(0)==')') return false;

        int n=s.length();

        if(n==1 && s.charAt(0)=='*') return true;

        Boolean[][][]dp=new Boolean[n+1][n+1][n+1];

        return solve(s,n,0,0,0,dp);
    }

    private static boolean solve(String s,int n,int i,int open,int close,Boolean [][][]dp){

        if(close>open) return false;

        if(i==n) return open==close;

        if(dp[i][open][close]!=null) return dp[i][open][close];
        
        char ch=s.charAt(i);

        if(ch=='*'){
            return dp[i][open][close]= solve(s,n,i+1,open+1,close,dp)||solve(s,n,i+1,open,close+1,dp)||solve(s,n,i+1,open,close,dp);
        }
        else{
            if(ch=='('){
                return dp[i][open][close]= solve(s,n,i+1,open+1,close,dp);
            }
            else{
                return dp[i][open][close]= solve(s,n,i+1,open,close+1,dp);
            }
        }

    }
}