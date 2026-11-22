class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int []ans=new int[n-k+1];

        int j=0;
        Deque<Integer>dq=new ArrayDeque<>();
        while(j<n){
            if(dq.isEmpty()){
                dq.offerLast(j);
            }
            else{
                if(nums[dq.peekLast()]>nums[j]){
                    dq.offerLast(j);
                }
                else{
                    while(!dq.isEmpty() &&nums[dq.peekLast()]<=nums[j]){
                        dq.pollLast();
                    }
                    dq.offerLast(j);
                }
            }
            while(!dq.isEmpty() && dq.peekFirst()<j-k+1){
                dq.pollFirst();
            }
            if(j>=k-1){
                ans[j-k+1]=nums[dq.peekFirst()];
            }
            j++;
        }
        return ans;
    }
}