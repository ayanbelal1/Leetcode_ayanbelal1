class Solution {
    int n;
    int[] arr;
    int mb;
    int [][]costs;
    int [][][]dp;

    public int minDistance(int[] houses, int k) {
        n=houses.length;
        arr=houses;

        Arrays.sort(houses);

        costs=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                int median=arr[i+(j-i)/2];

                int penalty=0;
                for(int x=i;x<=j;x++){
                    penalty+=Math.abs(arr[x]-median);
                }

                costs[i][j]=penalty;
            }
        }

        dp=new int [n+1][n+1][k+1];
        for(int [][]rows:dp){
            for(int []row:rows){
                Arrays.fill(row,-1);
            }
        }

        return solve(0,n-1,k);
    }

    private int solve(int i,int j,int k){
        
        if(i>j) return 0;

        if(k==1) return costs[i][j];

        if(j-i+1<=k) return 0;

        if(dp[i][j][k]!=-1) return dp[i][j][k];

        int ans=(int)1e9;
        for(int t=i;t<=j-k+1;t++){

            int penalty=costs[i][t];

            int cost=solve(t+1,j,k-1)+penalty;
            ans=Math.min(ans,cost);
        }
        return dp[i][j][k]=ans;
    }
}