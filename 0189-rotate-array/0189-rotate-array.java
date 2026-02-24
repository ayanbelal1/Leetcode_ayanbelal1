class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int temp[]=new int[n];
        Stack <Integer> st= new Stack<>();
        int t=n-1;
        for(int i=0;i<k;i++){
            st.push(nums[t]);
            t--;
        }
        int z=0;
        for (int j=0;j<n;j++){
            if (j<k){
                temp[j]=st.pop();
            }
            else{
                temp[j]=nums[z];
                z++;
            }
        }
        for(int i = 0; i < n; i++){
            nums[i] = temp[i];
        }
        
    }
}