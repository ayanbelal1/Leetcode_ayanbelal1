class Solution {
    public int minMoves(int[] nums) {
        
        int n=nums.length;

        int max=0;
        for(int i=0;i<n;i++){
            if(nums[max]<nums[i]){
                max=i;
            }
        }

        int ans=0;
        for(int i=0;i<n;i++){
            ans+=nums[max]-nums[i];
        }
        return ans;
    }
}