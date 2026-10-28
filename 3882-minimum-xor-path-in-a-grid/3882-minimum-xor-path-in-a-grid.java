class Solution {
    int n;
    int m;
    Integer [][][]dp;

    public int minCost(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        
        dp=new Integer[n+1][m+1][3000];

        return solve(grid,0,0,0);
    }

    private int solve(int [][]grid,int i,int j,int xor){

        int newXor=xor^grid[i][j];

        if(i==n-1 && j==m-1) return newXor;
        
        if(dp[i][j][xor]!=null) return dp[i][j][xor];

        int right=(j+1<m)?solve(grid,i,j+1,newXor): Integer.MAX_VALUE;
        int down=(i+1<n)?solve(grid,i+1,j,newXor): Integer.MAX_VALUE;

        return dp[i][j][xor]=Math.min(right,down);
    }
}