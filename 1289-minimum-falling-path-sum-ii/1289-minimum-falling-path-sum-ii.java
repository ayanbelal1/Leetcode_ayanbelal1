class Solution {
    int [][]dp;
    boolean [][]visited;
    public int minFallingPathSum(int[][] grid) {
        
        int n=grid.length;
        int min=Integer.MAX_VALUE;

        if(n==1){
            return grid[n-1][n-1];
        }

        visited=new boolean[n+1][n+1];
        dp=new int [n+1][n+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }

        for(int i=0;i<n;i++){
            min=Math.min(min,solve(grid,n,0,i));
        }
        return min;
    }

    public int solve(int [][]grid,int n,int i,int j){

        if(i>=n ) return 0;

        if(visited[i][j]) return dp[i][j];

        int min=Integer.MAX_VALUE;

        if(j>=0 && j<n){
            for(int x=0;x<n;x++){
                if(x==j) continue;

                int calc=grid[i][j]+solve(grid,n,i+1,x);
                min=Math.min(min,calc);
            }
        }
        visited[i][j]=true;
        return dp[i][j]= min;
    }
}