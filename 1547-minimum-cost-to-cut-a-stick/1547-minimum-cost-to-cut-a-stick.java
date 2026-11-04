class Solution {
    int []arr;
    int m;
    int [][]dp;

    public int minCost(int n, int[] cuts) {
        
        arr=new int[cuts.length+2];
        int m=arr.length;

        arr[0]=0;
        arr[m-1]=n;

        for(int i=1;i<m-1;i++){
            arr[i]=cuts[i-1];
        }

        Arrays.sort(arr);

        dp=new int [m][m];

        for(int gap=2;gap<m;gap++){
            for(int i=0;i+gap<m;i++){

                int j=i+gap;
                int ans=Integer.MAX_VALUE;

                for(int k=i+1;k<j;k++){

                    int cost=dp[i][k]+dp[k][j]+arr[j]-arr[i];
                    ans=Math.min(ans,cost);
                }
                dp[i][j]=ans;
            }

        }
        return dp[0][m-1];
    }
}