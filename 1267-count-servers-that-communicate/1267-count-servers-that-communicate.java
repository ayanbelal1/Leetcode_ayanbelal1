class Solution {
    int n;
    int m;

    public int countServers(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int[] rowCt=new int[n];
        int[] colCt=new int [m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) rowCt[i]+=1;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[j][i]==1) colCt[i]+=1;
            }
        }

        // for(int i=0;i<n;i++){
        //     System.out.print(rowCt[i]+" ");
        // }
        // System.out.println("");
        // for(int i=0;i<m;i++){
        //     System.out.print(colCt[i]+" ");
        // }

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int row=i;
                int col=j;
                if(grid[i][j]==1 &&rowCt[row]>1) ans++;
                else if (grid[i][j]==1 && colCt[col]>1) ans++;
                
            }
        }
        return ans;
    }
}