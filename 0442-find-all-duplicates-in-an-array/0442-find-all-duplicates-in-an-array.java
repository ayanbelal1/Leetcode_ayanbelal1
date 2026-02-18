class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        ArrayList <Integer> al=new ArrayList<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]==nums[++i]){
                for(int j=i;j<nums.length;j++){
                    if(nums[j]==nums[++j]){
                        count ++;
                        continue;
                        
                    }
                    else break;
                }
                if (count==2){
                    al.add(nums[i]);
                } 
            }
        }
        return al;
    }
}