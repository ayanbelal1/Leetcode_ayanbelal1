class Solution {
    int m;
    int []arr;
    int [][]dp;

    public int minCost(int n, int[] cuts) {
        arr=new int [cuts.length+2];
        m=arr.length;

        arr[0]=0;
        arr[m-1]=n;
        for(int i=1;i<m-1;i++){
            arr[i]=cuts[i-1];
        }

        dp=new int[m+1][m+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }

        Arrays.sort(arr);

        return solve(0,m-1);
    }

    private int solve(int i,int j){

        if(i+1==j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int minSum=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int cost=solve(i,k)+solve(k,j)+arr[j]-arr[i];
            minSum=Math.min(minSum,cost);
        }
        return dp[i][j]=minSum;
    }
}