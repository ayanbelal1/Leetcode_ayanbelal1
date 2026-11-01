class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int moves=0;

        if(n==1) return 0;
        
        if(allEqual(nums)) return 0;

        int minVal=Integer.MAX_VALUE;
        int minIDX=-1;
        for(int i=0;i<n;i++){
            minVal=Math.min(minVal,nums[i]);
            if(nums[i]==minVal) minIDX=i;
        }

        for(int i=0;i<n;i++){
            if(i!=minIDX){
                moves+=(int)Math.abs(minVal-nums[i]);
            }
        }
        return moves;
    }

    public boolean allEqual(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
    
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[0]) {
                return false; 
            }
        }
    
        return true;
    }
}