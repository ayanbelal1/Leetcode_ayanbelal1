public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int n = intervals.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int endI = intervals[i][1], endJ = intervals[j][1];
                int startI = intervals[i][0], startJ = intervals[j][0];
                if (endI > endJ || (endI == endJ && startI < startJ)) {
                    int[] tmp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = tmp;
                }
            }
        }
        for (int[] iv : intervals) {
            int l = iv[0], r = iv[1];
        int res = 0;
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE; 

       
            if (l > b) {
                res += 2;
                a = r - 1;
                b = r;
            } else if (l > a) {
                res += 1;
                a = b;
                b = r;
            }
        }

        return res;
    }
}