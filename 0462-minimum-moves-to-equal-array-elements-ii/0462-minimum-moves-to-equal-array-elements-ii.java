class Solution {
    int n;
    public int minMoves2(int[] nums) {
        n=nums.length;

        Arrays.sort(nums);
        int LB=n/2;

        int ans=0;
        for(int i=0;i<n;i++){
            if(i!=LB){
                ans+=Math.abs(nums[LB]-nums[i]);
            }
        }
        return ans;
    }

    // private int lowerBound(int []nums,int target){

    //     int low=0;
    //     int high=n-1;
    //     int lb=Integer.MAX_VALUE;

    //     while(low<=high){
    //         int mid=low+(high-low)/2;

    //         if(nums[mid]>=target){
    //             lb=Math.min(lb,mid);
    //             high=mid-1;
    //         }
    //         else{
    //             low=mid+1;
    //         }
    //     }
    //     return lb;
    // }
}