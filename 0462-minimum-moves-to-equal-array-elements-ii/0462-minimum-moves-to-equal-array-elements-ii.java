class Solution {
    int n;
    public int minMoves2(int[] nums) {
        n=nums.length;

        Arrays.sort(nums);
        int LB=n/2;

        int ans=0;
        for(int i=0;i<n/2;i++){
            if(i!=LB){
                ans+=Math.abs(nums[LB]-nums[i]);
                ans+=Math.abs(nums[n-i-1]-nums[LB]);
            }
        }
        return ans;
    }
}