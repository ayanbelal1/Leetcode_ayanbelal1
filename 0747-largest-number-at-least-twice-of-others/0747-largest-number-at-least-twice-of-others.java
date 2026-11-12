class Solution {
    public int dominantIndex(int[] nums) {
        int n=nums.length;
        int ans=0;

        for(int i=0;i<n;i++){
            if(nums[i]>nums[ans]){
                ans=i;
            }
        }

        boolean is=false;
        for(int i=0;i<n;i++){
            if(i!=ans && nums[ans]/2>=nums[i]){
                is=true;
            }
            else{
                if(ans==i){
                    if(is) is=true;
                }
                else{
                    return -1;
                }
            }
        }
        if(is) return ans;
        else return -1;
    }
}