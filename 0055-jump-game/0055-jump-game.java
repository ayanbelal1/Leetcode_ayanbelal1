class Solution {
    Boolean []dp;
    public boolean canJump(int[] nums) {
        int n=nums.length;
        
        dp=new Boolean[n];

        return solve(nums,0);
    }

    private boolean solve(int[]nums,int i){

        int n=nums.length;

        if(i==n-1) return true;
        if(i>=n) return false;

        if(dp[i]!=null) return dp[i];

        boolean is=false;
        for(int k=1;k<=nums[i];k++){
            is=solve(nums,i+k);
            if(is) break;
        }
        return dp[i]=is;
    }
}