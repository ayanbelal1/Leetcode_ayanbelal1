class Solution {
    public int longestSubsequence(String s, int k) {
        int zeros = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '0') zeros++;
        }
        // If k == 0 we can only use zeros (empty string counts as 0 but zeros increase length)
        long value = 0;
        long power = 1; // current place value (2^0, 2^1, ...)
        int result = zeros;

        // Try to include '1's from right to left (smallest contribution first)
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '1') {
                if (value + power <= k) {
                    value += power;
                    result++;        // included this '1'
                    power <<= 1;     // next 1 will have double the place value
                }
                
                if (power > k) break;
            }
        }
        return result;
    }
}
