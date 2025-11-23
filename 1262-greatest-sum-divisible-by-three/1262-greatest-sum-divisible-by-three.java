class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;

        // Use large numbers as "infinity"
        int INF = 1_000_000_000;

        // Two smallest numbers with remainder 1
        int min1_r1 = INF, min2_r1 = INF;
        // Two smallest numbers with remainder 2
        int min1_r2 = INF, min2_r2 = INF;

        // 1) Compute sum and track small remainders
        for (int x : nums) {
            sum += x;
            int r = x % 3;

            if (r == 1) {
                if (x < min1_r1) {
                    min2_r1 = min1_r1;
                    min1_r1 = x;
                } else if (x < min2_r1) {
                    min2_r1 = x;
                }
            } else if (r == 2) {
                if (x < min1_r2) {
                    min2_r2 = min1_r2;
                    min1_r2 = x;
                } else if (x < min2_r2) {
                    min2_r2 = x;
                }
            }
        }

        int rSum = sum % 3;
        if (rSum == 0) return sum;

        int ans = 0;
        if (rSum == 1) {
            // Option 1: remove one remainder-1 number
            int option1 = (min1_r1 == INF) ? INF : sum - min1_r1;
            // Option 2: remove two remainder-2 numbers
            int option2 = (min2_r2 == INF) ? INF : sum - (min1_r2 + min2_r2);
            ans = Math.max(0, Math.min(option1, option2));
        } else { // rSum == 2
            // Option 1: remove one remainder-2 number
            int option1 = (min1_r2 == INF) ? INF : sum - min1_r2;
            // Option 2: remove two remainder-1 numbers
            int option2 = (min2_r1 == INF) ? INF : sum - (min1_r1 + min2_r1);
            ans = Math.max(0, Math.min(option1, option2));
        }

        return ans;
    }
}
