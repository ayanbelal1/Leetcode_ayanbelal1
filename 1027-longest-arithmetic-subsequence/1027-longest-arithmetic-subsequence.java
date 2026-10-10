class Solution {
    public int longestArithSeqLength(int[] nums) {
        
        int n=nums.length;
        if(n<=0) return 0;

        Map<Integer,Integer>[] ls=new HashMap[n];
        for(int i=0;i<n;i++){
            ls[i]=new HashMap<>();
        }

        int max=2;


        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                
                int diff=nums[i]-nums[j];

                int len=ls[j].getOrDefault(diff,1)+1;

                ls[i].put(diff,Math.max(ls[i].getOrDefault(diff,0),len));

                max=Math.max(len,max);

            }
        }

        return max;
    }
}