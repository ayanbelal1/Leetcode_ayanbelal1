class Solution {
    public long maxTotalValue(int[] nums, int k) {

        long min=(int)1e9;
        long max=(int)-1e9;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }

        return (long)((max-min)*(long)k);
    }
}