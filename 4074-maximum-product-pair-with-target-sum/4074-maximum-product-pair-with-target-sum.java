class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int []ans={-1,-1};

        int [][]arr=new int[nums.length][2];
        int n=nums.length;

        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        
        int i=0;int j=nums.length-1;
        long product=Long.MIN_VALUE;
        
        while(i<j){
            long sum=(long) arr[i][0]+arr[j][0];
            
            if(sum==target){
                if (arr[i][0]<arr[j][0]){
                    long temp=(long) arr[i][0]*arr[j][0];
                    if(temp>product){
                        product=temp;
                        ans[0]=arr[j][1];
                        ans[1]=arr[i][1];
                        
                    }
                }
                i++;
                j--;
            }
            else if(sum<target){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
}