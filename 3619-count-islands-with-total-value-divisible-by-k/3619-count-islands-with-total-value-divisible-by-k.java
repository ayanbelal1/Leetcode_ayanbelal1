class Solution {
    int m;
    int n;
    boolean [][]visited;
    public int countIslands(int[][] grid, int k) {
        n=grid.length;
        m=grid[0].length;

        int count=0;
        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0 && !visited[i][j]){
                    long sum=check(grid,i,j);

                    if(sum%k==0) count++;
                }
            }
        }
        return count;
    }

    private long check(int [][]grid,int i,int j){

        if(i<0 || i>=n || j<0 || j>=m) return 0;

        if(grid[i][j]==0) return 0;

        if(visited[i][j]) return 0;

        visited[i][j]=true;

        long sum = grid[i][j];

        sum+=check(grid,i,j-1);
        sum+=check(grid,i,j+1);
        sum+=check(grid,i+1,j);
        sum+=check(grid,i-1,j);

        return sum;

    }
}