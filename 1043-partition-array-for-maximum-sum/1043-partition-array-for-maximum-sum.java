class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n=arr.length;

        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);

        return solve(arr,k,0,n,dp);
    }
    private static int solve(int []arr,int k,int i,int n,int []dp){

        if(i>=n) return 0;

        int maxVal=0;
        int maxSum=0;

        if(dp[i]!=-1) return dp[i];

        for(int j=1;j<=k && i+j-1<n;j++){

            maxVal=Math.max(maxVal,arr[i+j-1]);

            int sum=maxVal*j + solve(arr,k,i+j,n,dp);

            maxSum=Math.max(maxSum,sum);
            
        }
        return dp[i]=maxSum;
    }
}