class Solution {
    public int[] runningSum(int[] nums) {
        int n=nums.length;
        int runS[]=new int [n];
        runS[0]=nums[0];
        for (int i=1;i<n;i++){
            runS[i]=runS[i-1]+nums[i];
        }
        return runS;
    }
}