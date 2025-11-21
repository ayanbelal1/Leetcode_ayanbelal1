class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last  = new int[26];
        java.util.Arrays.fill(first, -1);
        java.util.Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] == -1) first[ch] = i;
            last[ch] = i;
        }

        int ans = 0;
        for (int c = 0; c < 26; c++) {
            int l = first[c];
            int r = last[c];
            if (l == -1 || l + 1 >= r) continue; 
            boolean[] seen = new boolean[26];
            for (int i = l + 1; i < r; i++) {
                seen[s.charAt(i) - 'a'] = true;
            }
            for (int m = 0; m < 26; m++) if (seen[m]) ans++;
        }

        return ans;
    }
}

    