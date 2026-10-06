class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n=matrix.length;
        int m=matrix[0].length;

        int high=m-1;
        int low=0;
        int ansRow=-1;
        int ansCol=-1;
        while(low<=high){

            int mid=low+(high-low)/2;

            if(matrix[0][mid]>target){
                high=mid-1;
            }
            else if(matrix[0][mid]==target) return true;

            else{
                low=mid+1;
                ansCol=mid;
            }
        }
        if(ansCol == -1) return false;

        for(int i=ansCol;i>=0;i--){
            int lo=0;
            int hi=n-1;
            while(lo<=hi){

                int mid=lo+(hi-lo)/2;

                if(matrix[mid][i]>target){
                    hi=mid-1;
                }
                else if(matrix[mid][i]==target) return true;

                else{
                    lo=mid+1;
                    ansRow=mid;
                }
            }
        }
        if(matrix[ansRow][ansCol]==target) return true;

        return false;
    }
}