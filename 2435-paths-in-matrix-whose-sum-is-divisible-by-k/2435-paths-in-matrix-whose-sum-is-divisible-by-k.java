class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int MOD = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k];

        int startRem = grid[0][0] % k;
        dp[0][0][startRem] = 1;

        
            for (int j = 0; j < n; j++) {

                
                if (i == 0 && j == 0) continue;

                int val = grid[i][j] % k; 
                for (int r = 0; r < k; r++) {
                    long ways = 0;

                    
                    if (i > 0) {
                        ways += dp[i - 1][j][r];
                    }

                    if (j > 0) {
                        ways += dp[i][j - 1][r];
                    }

                    
                    if (ways == 0) continue;

                    
                    int newRem = (r + val) % k;
                    dp[i][j][newRem] = (int) ((dp[i][j][newRem] + ways) % MOD);
                }
            }
        }

        // We want the number of paths with sum % k == 0 at the bottom-right cell
        return dp[m - 1][n - 1][0];
    }
}
