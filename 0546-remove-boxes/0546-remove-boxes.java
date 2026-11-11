class Solution {
    int n;
    int [][][]dp;

    public int removeBoxes(int[] boxes) {
        n=boxes.length;

        dp=new int[n+1][n+1][101];
        for(int [][]rows:dp){
            for(int []row:rows){
                Arrays.fill(row,-1);
            }
        }   
        return solve(0,n-1,0,boxes);
    }

    private int solve(int i,int j,int count,int []boxes){
        
        if(i>j) return 0;

        while(i<j){
            if(i+1<=j && boxes[i]==boxes[i+1]){
                i++;count++;
            }
            else break;
        }

        if(dp[i][j][count]!=-1) return dp[i][j][count];
        
        int ans=(count+1)*(count+1)+solve(i+1,j,0,boxes);
        
        for(int k=i+1;k<=j;k++){
            if(boxes[i]==boxes[k]){
                int cost=solve(k,j,count+1,boxes)+solve(i+1,k-1,0,boxes);
                ans=Math.max(ans,cost);
            }
        }
        return dp[i][j][count]=ans;
    }
}