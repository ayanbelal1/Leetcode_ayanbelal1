class Solution {
    public int[] twoSum(int[] nums, int target) {

        int []temp=Arrays.copyOf(nums,nums.length);
        Arrays.sort(temp);

        int n=temp.length;
        int i=0;
        int j=n-1;

        int value1=0;
        int value2=0;

        while(i<j){
            if(temp[i]+temp[j]>target){
                j--;
            }
            else if(temp[i]+temp[j]<target){
                i++;
            }
            else{
                value1=temp[i];
                value2=temp[j];
                break;
            }
        }
        int []ans=new int[2];
        int ind=0;
        
        for(int x=0;x<n;x++){
            
            if(nums[x]==value1 || nums[x]==value2){
                ans[ind]=x;
                ind++;
            }
        }
        return ans;
    }
}