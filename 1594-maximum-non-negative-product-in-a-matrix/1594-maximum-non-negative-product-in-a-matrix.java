class Solution {
    static long MOD=1000000007;
    public int maxProductPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        long dpMax[][]=new long[n+1][m+1];
        long dpMin[][]=new long[n+1][m+1];
        boolean [][]visited=new boolean[n][m];

        long[] ans= solve(grid,n,m,0,0,dpMax,dpMin,visited);

        long maxP=ans[0];

        if(maxP<0) return -1;

        return (int)(maxP%MOD);
    }

    private static long[] solve(int [][]grid,int n,int m,int i,int j,long [][]dpMax,long [][]dpMin,boolean [][]visited){

        if(i==n-1 && j==m-1){
            visited[i][j]=true;
            dpMax[i][j]=grid[i][j];
            dpMin[i][j]=grid[i][j];
            return new long[]{dpMax[i][j],dpMin[i][j]};
        } 

        if (visited[i][j]) {
            return new long[]{dpMax[i][j], dpMin[i][j]};
        }

        long max=Long.MIN_VALUE;
        long min=Long.MAX_VALUE;

        visited[i][j]=true;

        if(i+1<n){
            long []down=solve(grid,n,m,i+1,j,dpMax,dpMin,visited);

            long a=down[0]*(long)grid[i][j];
            long b=down[1]*(long)grid[i][j];

            max=Math.max(max,Math.max(a,b));
            min=Math.min(min,Math.min(a,b));

        }

        if(j+1<m){
            long []right=solve(grid,n,m,i,j+1,dpMax,dpMin,visited);

            long a=right[0]*(long)grid[i][j];
            long b=right[1]*(long)grid[i][j];

            max=Math.max(max,Math.max(a,b));
            min=Math.min(min,Math.min(a,b));

        }
        dpMax[i][j]=max;
        dpMin[i][j]=min;
        return new long[]{dpMax[i][j],dpMin[i][j]};
    }
}