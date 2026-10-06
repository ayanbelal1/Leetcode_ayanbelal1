class Solution {
    public int lengthOfLIS(int[] nums) {
        return minDeletions(nums);
    }
    public static int minDeletions(int[] arr) {
        int n=arr.length;
        
        ArrayList<Integer> al=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            
            if(al.isEmpty() || al.get(al.size()-1)<arr[i]){
                al.add(arr[i]);
            }
            else{
                int temp=lowerBound(al,0,al.size()-1,arr[i]);
                al.set(temp,arr[i]);
            }
        }
        return al.size();
    }
    
    private static int lowerBound(ArrayList<Integer> al,int i,int j,int target){
        int ans=Integer.MAX_VALUE;
        while(i<=j){
            int mid=i+(j-i)/2;
            
            if(al.get(mid)>=target){
                j=mid-1;
                ans=Math.min(ans,mid);
            }
            else{
                i=mid+1;
            }
        }
        return ans;
    }
}
