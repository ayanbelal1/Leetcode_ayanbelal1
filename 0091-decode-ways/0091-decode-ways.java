class Solution {
    public int numDecodings(String s) {

        int dp[]=new int[s.length()+1];

        Arrays.fill(dp,-1);
        return solve(s,"",0,dp);
    }

    public static int solve(String s,String x,int i,int[] dp){

        if(i == s.length())
            return 1;

        if(dp[i]!=-1) return dp[i];
        if(x.isEmpty()){

            if(s.charAt(i) == '0')
                return 0;

            int takeOne = solve(s,s.substring(i,i+1),i+1,dp);

            int takeTwo = 0;

            if(i+1 < s.length()){
                int num = Integer.parseInt(s.substring(i,i+2));
                if(num >= 10 && num <= 26){
                    takeTwo = solve(s,s.substring(i,i+2),i+2,dp);
                }
            }

            return dp[i]=takeOne + takeTwo;
        }

        if(Integer.parseInt(x) > 26)
            return 0;

        if(x.charAt(0) == '0')
            return 0;

        if(i == s.length())
            return 1;

        int takeOne = 0;

        if(s.charAt(i) != '0')
            takeOne = solve(s,s.substring(i,i+1),i+1,dp);

        int takeTwo = 0;

        if(i+1 < s.length()){
            int num = Integer.parseInt(s.substring(i,i+2));

            if(num >= 10 && num <= 26)
                takeTwo = solve(s,s.substring(i,i+2),i+2,dp);
        }

        return dp[i]= takeOne + takeTwo;
    }
}