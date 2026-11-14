class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        
        int n=nums.size();
        int min=(int)1e9;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums.get(j);
                if(l<=j-i+1 && j-i+1<=r){
                    if(sum>0) min=Math.min(min,sum);
                }
            }
        }
        return min==(1e9)?-1:min;
    }
}