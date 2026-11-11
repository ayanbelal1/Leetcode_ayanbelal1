class Solution {
    int n;
    int [][]dp;

    public boolean predictTheWinner(int[] nums) {
        n=nums.length;

        dp=new int[n+1][n+1];
        for(int[] row:dp) Arrays.fill(row,-1);

        return solve(0,n-1,nums)>=0;
    }

    private int solve(int i,int j,int[] nums){

        if(i==j){
            return nums[i];
        }

        if(dp[i][j]!=-1) return dp[i][j];

        int []choices={nums[i],nums[j]};

        int left=choices[0]-solve(i+1,j,nums);
        int right=choices[1]-solve(i,j-1,nums);

        return dp[i][j]=Math.max(left,right);
    }
}