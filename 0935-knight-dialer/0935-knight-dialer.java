class Solution {
    int row;
    int col;
    int [][]numPad;
    int [][][]dp;
    int[] dr={-2,-2,2,2,1,-1,1,-1};
    int[] dc={-1,1,-1,1,-2,-2,2,2};
    static final int MOD = 1000000007;

    public int knightDialer(int n) {
        row=4;
        col=3;

        int count=1;
        numPad=new int[row][col];
        for(int i=0;i<col;i++){
            for(int j=0;j<col;j++){
                numPad[i][j]=count;
                count++;
            }
        }
        numPad[3][0]=-1;
        numPad[3][1]=0;
        numPad[3][2]=-1;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(numPad[i][j]+" ");
            }
            System.out.println("");
        }

        dp=new int[row][col][n];
        for(int[][] rows:dp){
            for(int[] row:rows){
                Arrays.fill(row,-1);
            }
        }

        int ansCount=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(numPad[i][j]!=-1){
                    ansCount=(ansCount+solve(i,j,n-1))%MOD;
                }
            }
        }
        return ansCount;
    }

    private int solve(int i,int j,int n){

        if(i<0 || i>=row || j<0 || j>=col) return 0;

        if(n<=0) return 1;

        if(dp[i][j][n]!=-1) return dp[i][j][n];

        int ans=0;
        for(int dir=0;dir<8;dir++){
            int newI=i+dr[dir];
            int newJ=j+dc[dir];

            if(newI>=0 && newI<row && newJ>=0 && newJ<col && numPad[newI][newJ]!=-1) ans=(ans+solve(newI,newJ,n-1))%MOD;
        }
        return dp[i][j][n]=ans;
    }
}