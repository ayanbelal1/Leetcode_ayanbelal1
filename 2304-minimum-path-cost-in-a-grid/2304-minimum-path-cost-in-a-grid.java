class Solution {
    int [][]dp;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        
        int n=grid.length;
        int m=grid[0].length;

        dp=new int[n+1][m+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }

        int minAns=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            minAns=Math.min(minAns,solve(grid,moveCost,n,m,0,i));
        }
        return minAns;
    }

    public int solve(int [][]grid,int [][]moveCost,int n,int m,int i,int j){

        if(i == n-1) return grid[i][j];

        if(dp[i][j]!=-1) return dp[i][j];

        int min=Integer.MAX_VALUE;
        for(int x=0;x<m;x++){
           
            int cost=grid[i][j]+moveCost[grid[i][j]][x]+solve(grid,moveCost,n,m,i+1,x);
            min=Math.min(cost,min);
        }
        return dp[i][j]=min;
    }
}