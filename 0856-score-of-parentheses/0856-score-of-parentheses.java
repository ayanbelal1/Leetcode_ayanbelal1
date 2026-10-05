class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.push(0);

        int score = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                ad.push(0);
            }

            if (ch == ')') {
                int tempScore = ad.pop();

                if (tempScore == 0) {
                    tempScore = 1;
                }
                else {
                    tempScore *= 2;
                }

                ad.push(ad.pop() + tempScore);
            }
        }

        return ad.pop();
    }
}