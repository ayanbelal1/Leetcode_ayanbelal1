class Solution {
    static final int MOD=(int)1e9+7;
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        long []helper=new long[n];

        helper[0]=arr[0];
        for(int i=1;i<n;i++){
            helper[i]=helper[i-1]+(long)arr[i];
        }

        long ansCount=0;
        long evenCount=1;
        long oddCount=0;

        for(int i=0;i<n;i++){
            if(helper[i]%2==0){
                evenCount++;
                if(oddCount!=0) ansCount+=oddCount;
            }
            else{
                ansCount+=evenCount;
                oddCount++;
            }
        }
        return (int)(ansCount%MOD);
    }
}