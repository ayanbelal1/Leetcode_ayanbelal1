class Solution {
    int n;
    int []arr;
    int [][]dp;

    public int maxCoins(int[] nums) {
        n=nums.length;

        arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }

        dp=new int[n+1][n+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }

        return solve(1,n);
    }

    private int solve(int i,int j){
        
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int ans=(int)-1e9;
        for(int k=i;k<=j;k++){
            int cost=solve(i,k-1)+solve(k+1,j)+arr[i-1]*arr[k]*arr[j+1];
            ans=Math.max(cost,ans);
        }

        return dp[i][j]=ans;
    }
}