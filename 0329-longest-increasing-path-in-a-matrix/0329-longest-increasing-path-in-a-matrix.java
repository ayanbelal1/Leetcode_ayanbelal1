class Solution {
    int n;
    int m;
    int [][]dp;

    public int longestIncreasingPath(int[][] matrix) {
        
        n=matrix.length;
        m=matrix[0].length;

        dp=new int[n][m];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }

        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean [][]visited=new boolean[n][m];
                ans=Math.max(ans,1+solve(matrix,i,j,visited));
            }
        }
        return ans;
    }

    private int solve(int [][]matrix,int i,int j,boolean [][]visited){

        if(i>=n ||j>=m || i<0 ||j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(visited[i][j]) return 0; 
        
        visited[i][j]=true;

        int up=0;
        int down=0;
        int right=0;
        int left=0;

        if(i-1>=0 && matrix[i-1][j]>matrix[i][j]) up=1+solve(matrix,i-1,j,visited);
        if(i+1<n && matrix[i+1][j]>matrix[i][j]) down=1+solve(matrix,i+1,j,visited);
        if(j-1>=0 && matrix[i][j-1]>matrix[i][j]) left=1+solve(matrix,i,j-1,visited);
        if(j+1<m && matrix[i][j+1]>matrix[i][j]) right=1+solve(matrix,i,j+1,visited);
        
        return dp[i][j]=Math.max(Math.max(up,down),Math.max(left,right));
    }
}