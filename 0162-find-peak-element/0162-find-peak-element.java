class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int largest=nums[0];
        int temp=0;
        if(n==1) {return 0;}
        else{
        for(int i=0;i<n-1;i++){
            if(largest<nums[i]){
                largest=nums[i];
            }
        }
        for(int j=0;j<n-1;j++){
            if(nums[j]==largest){
                temp=j;
            }
        }
        }
        return temp;
    }
}