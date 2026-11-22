class Solution {
    public long minCost(int[] nums) {
        int n=nums.length;
        long []prefix=new long[n];
        long []postfix=new long[n];
        
        for(int i=1;i<n-1;i++){
            if(nums[i]!=nums[i-1]){
                prefix[i]=(long)i*nums[i];
            }
            else prefix[i]=prefix[i-1];
        }

        for(int i=n-2;i>0;i--){
            if(nums[i]!=nums[i+1]){
                postfix[i]=(long)(n-i-1)*nums[i];
            }
            else postfix[i]=postfix[i+1];
        }

        long ans=Long.MAX_VALUE;;
        for(int i=1;i<n-1;i++){
            ans=Math.min(ans,prefix[i]+postfix[i]);
        }

        return ans;
    }
}