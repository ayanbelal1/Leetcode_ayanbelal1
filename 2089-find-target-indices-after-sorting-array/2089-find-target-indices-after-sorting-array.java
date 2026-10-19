class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int smaller=0;
        int same=0;

        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]<target){
                smaller++;
            }
            if(nums[i]==target) same ++;
        }

        List<Integer> al=new ArrayList<>();

        if(same==0) return al;

        int idx=smaller;
        while(idx<=smaller+same-1){
            al.add(idx);
            idx++;
        }
        return al;
    }
}