class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n=nums.length;

        Arrays.sort(nums);

        int left=0;
        int right=n-1;
        int idx=-1;
        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]>=target){
                idx=mid;
                right=mid-1;
            }
            else if(nums[mid]<target){
                
                left=mid+1;
            }
        }
        if(idx==-1 || nums[idx]!=target) return new ArrayList<>();

        int i=idx;
        List<Integer>al=new ArrayList<>();

        while(i<n){
            if(nums[i]==target){
                al.add(i);
                i++;
            }
            else break;
        }
        return al;
    }
}