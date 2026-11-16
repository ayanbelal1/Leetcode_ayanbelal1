class NumMatrix {
    int n;
    int m;
    int [][]helper;

    public NumMatrix(int[][] matrix) {
        this.n=matrix.length;
        this.m=matrix[0].length;
        helper=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j-1<0 || i-1<0){
                    if(i-1<0 && j-1<0){
                        helper[i][j]=matrix[i][j];
                    }
                    else if(i-1<0 && j-1>=0){
                        helper[i][j]=helper[i][j-1]+matrix[i][j];
                    }
                    else if(i-1>=0 && j-1<0){
                        helper[i][j]=helper[i-1][j]+matrix[i][j];
                    }
                }
                else{
                    helper[i][j]=helper[i][j-1]+matrix[i][j]+helper[i-1][j]-helper[i-1][j-1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        if(row1-1>=0 && col1-1>=0){
            return helper[row2][col2]-(helper[row1-1][col2]+helper[row2][col1-1])+helper[row1-1][col1-1];
        }
        else{
            if(row1-1<0 && col1-1>=0){
                return helper[row2][col2]-(helper[row2][col1-1]);
            }
            else if (row1-1>=0 && col1-1<0){
                return helper[row2][col2]-(helper[row1-1][col2]);
            }
            else{
                return helper[row2][col2];
            }
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */