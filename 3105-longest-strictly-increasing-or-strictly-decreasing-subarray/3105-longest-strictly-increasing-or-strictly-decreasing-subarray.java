class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;

        
        int longest=1;
        for(int i=0;i<n;i++){
            int prev=-1;
            for(int j=i;j<n;j++){
                if(prev!=-1 && nums[j]>nums[prev]){
                    longest=Math.max(longest,j-i+1);
                }
                else{
                    if(prev!=-1) break;
                }
                prev=j;
            }
            prev=-1;
            for(int j=i;j<n;j++){
                
                if(prev!=-1 && nums[prev]>nums[j]){
                    longest=Math.max(longest,j-i+1);
                }
                else{
                    if(prev!=-1) break;
                }
                prev=j;
            }
        }
        return longest;
    }
}





