class Solution {
    int [][]dp;
    int[] helper;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;

        int check = k;
        boolean possible = false;

        if (n == 1) return 0;
        
        while (check <= n) {
            if (check == n) {
                possible = true;
            }
            check += k - 1;
        }

        helper = new int[n];
        helper[0] = stones[0];

        for (int i = 1; i < n; i++) {
            helper[i] = helper[i - 1] + stones[i];
        }

        dp=new int[n+1][n+1];     
        for(int []row:dp){
            Arrays.fill(row,-1);
        }

        if (possible) {
            return solve(stones, k, 0, n - 1);
        }
        return -1;
    }

    private int solve(int[] stones, int k, int i, int j) {
        if (j==i) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int z = i; z < j; z+=k-1) {
            int cost = solve(stones, k, i, z) + solve(stones, k, z + 1, j);
            min = Math.min(min, cost);
        }

        if((j-i)%(k-1)==0){
            min+=helper[j]-(i > 0?helper[i - 1]:0);

        }

        if (min == Integer.MAX_VALUE) return 0;

        return dp[i][j]=min;
    }
}
