class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return getLIS(nums);

    }

    public static ArrayList<Integer> getLIS(int arr[]) {
        
        int n=arr.length;
        
        int []dp=new int[n];
        int []parent=new int[n];
        
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                
                if(arr[i]%arr[j]==0){
                    
                    if(dp[j]+1>dp[i]){
                        
                        dp[i]=1+dp[j];
                        parent[i]=j;
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[i]);
        }
        
        int itr=-1;
        for(int i=0;i<n;i++){
            
            if(dp[i]==max){
                itr=i;
                break;
            }
        }
        ArrayList<Integer> al=new ArrayList<>();
        while(itr>=0){
            al.add(arr[itr]);
            
            itr=parent[itr];
            
        }
        
    Collections.reverse(al);
    return al;
    }
}