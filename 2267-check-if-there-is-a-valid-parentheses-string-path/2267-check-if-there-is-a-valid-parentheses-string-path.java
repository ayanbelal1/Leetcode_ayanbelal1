class Solution {
    public boolean hasValidPath(char[][] grid) {
        
        int row=grid.length;
        int col=grid[0].length;

        if(grid[0][0]==')' || grid[row-1][col-1] == '(') return false;
        
        Boolean [][][]dp=new Boolean[row+1][col+1][row+col+1];
        
        return solve(grid,row,col,0,0,0,dp);
    }

    private static boolean solve(char [][]grid,int row,int col,int i,int j,int count,Boolean [][][]dp){

        if(i==row-1 && j==col-1) return count==1;

        if(i>=row || j>=col) return false;
        if (count < 0) return false;

        if(dp[i][j][count]!=null) return dp[i][j][count];

        boolean right=false;
        boolean down =false;
        if(grid[i][j]=='('){
            right=solve(grid,row,col,i,j+1,count+1,dp);
            down=solve(grid,row,col,i+1,j,count+1,dp); 
        }
        
        if(grid[i][j]==')'){
            right=solve(grid,row,col,i,j+1,count -1,dp);
            down=solve(grid,row,col,i+1,j,count-1,dp);
        }
        return dp[i][j][count]= right || down;
    }
}