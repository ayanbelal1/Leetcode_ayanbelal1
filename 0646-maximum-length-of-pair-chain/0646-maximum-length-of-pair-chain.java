class Solution {
    public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));

        int n=pairs.length;
        int []dp=new int[n];
        Arrays.fill(dp,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){

                if(pairs[i][0]>pairs[j][1]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
        }

        int max=1;
        for(int x:dp){
            max=Math.max(max,x);
        }
        return max;
    }
}