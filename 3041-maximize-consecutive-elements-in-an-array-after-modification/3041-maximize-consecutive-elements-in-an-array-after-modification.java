class Solution {
    int n;
    int []nums;
    int [][]dp;

    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        n=nums.length;
        this.nums=nums;
        
        dp=new int [n+1][2];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }

        int result=1;
        for(int i=0;i<n;i++){
            int potential=Math.max(solve(i,0),solve(i,1));
            result=Math.max(result,potential);
        }
        return result;
    }

    private int solve(int i,int incOrDec){

        if(i>=n) return 0;

        if(dp[i][incOrDec]!=-1) return dp[i][incOrDec];
        
        int currSum=nums[i]+incOrDec;

        int len=1;

        int find=lowerBound(currSum,i+1);

        if(find!=-1 && nums[find]==currSum){
            len=Math.max(len,1+solve(find,1));
        }

        find=lowerBound(currSum+1,i+1);
        if(find!=-1 &&nums[find]==currSum+1){
            len=Math.max(len,1+solve(find,0));
        }

        return dp[i][incOrDec]=len;
    }

    private int lowerBound(int target,int index){

        int low=index;
        int high=n-1;
        int ans=(int)1e9;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]>=target){
                ans=Math.min(ans,mid);
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans==(int)1e9?-1:ans;
    }
}