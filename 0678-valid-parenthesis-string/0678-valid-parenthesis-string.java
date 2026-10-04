class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n + 1][n + 1];

        return solve(s, n, 0, 0, 0, dp);
    }

    private static boolean solve(String s, int n, int i, int open, int close,Boolean[][] dp) {

        if (close > open) return false;
        if (i == n) return open == close;

        int balance = open - close;

        if (dp[i][balance] != null) {
            return dp[i][balance];
        }

        char ch = s.charAt(i);
        boolean ans;

        if (ch == '*') {
            ans = solve(s, n, i + 1, open + 1, close, dp) || solve(s, n, i + 1, open, close + 1, dp) || solve(s, n, i + 1, open, close, dp);
        } else if (ch == '(') {
            ans = solve(s, n, i + 1, open + 1, close, dp);
        } else {
            ans = solve(s, n, i + 1, open, close + 1, dp);
        }

        return dp[i][balance] = ans;
    }
}