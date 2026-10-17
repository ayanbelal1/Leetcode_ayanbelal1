class Solution {
    // Boolean []dp;
    public boolean canJump(int[] nums) {
        int n=nums.length;
        
        int reach=0;
        for(int i=0;i<n;i++){

            if(i>reach) return false;

            reach=Math.max(reach,i+nums[i]);

        }
        return true;
    }

    // private boolean solve(int[]nums,int i){

    //     int n=nums.length;

    //     if(i==n-1) return true;
    //     if(i>=n) return false;

    //     if(dp[i]!=null) return dp[i];

    //     boolean is=false;
    //     for(int k=1;k<=nums[i];k++){
    //         is=solve(nums,i+k);
    //         if(is) break;
    //     }
    //     return dp[i]=is;
    // }
}