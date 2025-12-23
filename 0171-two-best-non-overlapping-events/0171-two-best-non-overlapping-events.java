import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] endSorted = events.clone();
        Arrays.sort(endSorted, (a, b) -> Integer.compare(a[1], b[1]));

        int n = events.length;
        int maxValueSoFar = 0;
        int ans = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int value = events[i][2];
            while (j < n && endSorted[j][1] < start) {
                maxValueSoFar = Math.max(maxValueSoFar, endSorted[j][2]);
                j++;
            }
            ans = Math.max(ans, maxValueSoFar + value);
        }

        return ans;
    }
}
