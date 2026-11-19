class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans =(int)1e9;

        ans=Math.min(ans,nums[n-1]-nums[2]);
        ans=Math.min(ans,nums[n-2]-nums[1]);
        ans=Math.min(ans,nums[n-3]-nums[0]);

        return ans;
    }
}