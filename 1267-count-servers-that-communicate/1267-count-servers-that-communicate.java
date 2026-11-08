class Solution {
    int n;
    int m;
    int []dr={1,-1,0,0};
    int []dc={0,0,1,-1};

    public int countServers(int[][] grid) {
        n=grid.length;
        m=grid[0].length;

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) ans+=find(grid,i,j);
            }
        }
        return ans;
    }

    private int find(int [][]grid,int row,int col){
        boolean canCommunicate=false;
        for(int i=0;i<m;i++){
            if(grid[row][i] ==1 && i!=col) canCommunicate=true;
        }

        if(canCommunicate) return 1;

        else{
            for(int i=0;i<n;i++){
                if(grid[i][col]==1 && i!=row) canCommunicate=true;
            }
        }
        return canCommunicate?1:0;
    }
}