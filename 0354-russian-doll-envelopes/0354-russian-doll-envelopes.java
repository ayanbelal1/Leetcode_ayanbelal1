class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
        if (a[0] == b[0]) {
            return Integer.compare(b[1], a[1]); 
          }
            return Integer.compare(a[0], b[0]);     
        });

        return env(envelopes);
    }
    public static int env(int[][] arr) {
        
        int n=arr.length;
        
        ArrayList<Integer> al=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            
            if(al.isEmpty() || al.get(al.size()-1)<arr[i][1]){
                al.add(arr[i][1]);
            }
            else{
                int temp=lowerBound(al,0,al.size()-1,arr[i][1]);
                al.set(temp,arr[i][1]);
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