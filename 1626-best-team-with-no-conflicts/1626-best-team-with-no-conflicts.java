class Solution {
    int n;
    int [][]combined;

    public int bestTeamScore(int[] scores, int[] ages) {
        n=scores.length;
        combined=new int[n][2];

        for(int i=0;i<n;i++){
            combined[i][0]=ages[i];
            combined[i][1]=scores[i];
        }

        Arrays.sort(combined,(a,b) ->{
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });

        int []dp=new int[n];
        dp[0]=combined[0][1];
        for(int i=0;i<n;i++){
            dp[i] = combined[i][1];
            for(int j=0;j<i;j++){
                if(combined[i][1]>=combined[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+combined[i][1]);
                }
            }
        }

        int ans=(int)-1e9;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}