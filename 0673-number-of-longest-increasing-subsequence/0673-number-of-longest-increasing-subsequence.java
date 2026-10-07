class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(dp2, 1);

        int max = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    if (dp[j] + 1 > dp[i]) {

                        dp[i] = dp[j] + 1;
                        dp2[i] = dp2[j];

                    }
                
                    else if (dp[j] + 1 == dp[i]) {

                        dp2[i] += dp2[j];
                    }
                }
            }

            max = Math.max(max, dp[i]);
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