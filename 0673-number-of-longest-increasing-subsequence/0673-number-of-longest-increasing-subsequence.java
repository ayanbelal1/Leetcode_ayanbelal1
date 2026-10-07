class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp, 1);
        
        int max = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        for (int i = 0; i < n; i++) {

            if(dp[i]==1){
                dp2[i]=1;
            }
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    
                    if (dp[j] == dp[i] - 1) {
                        dp2[i] += dp2[j];
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {

            if (dp[i] == max) {
                answer += dp2[i];
            }
        }

        return answer;
    }
}