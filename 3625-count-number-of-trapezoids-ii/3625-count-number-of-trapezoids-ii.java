public class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        HashMap<Long, HashMap<Long, Integer>> slopeMap = new HashMap<>();
        HashMap<Long, Integer> midMap = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            int xi = points[i][0], yi = points[i][1];
            for (int j = i + 1; j < n; ++j) {
                int xj = points[j][0], yj = points[j][1];
                int dx = xj - xi;
                int dy = yj - yi;

                int g = gcd(Math.abs(dx), Math.abs(dy));
                dx /= g;
                dy /= g;

                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }

                long slopeKey = (((long) dy) << 32) | ((long) dx & 0xffffffffL);
                long lineKey = (long) dy * xi - (long) dx * yi;

                slopeMap
                    .computeIfAbsent(slopeKey, k -> new HashMap<>())
                    .merge(lineKey, 1, Integer::sum);

                long mx = (long) xi + xj;
                long my = (long) yi + yj;
                long midKey = (mx << 32) | (my & 0xffffffffL);
                midMap.merge(midKey, 1, Integer::sum);
            }
        }

        long trapezoidPairs = 0;
        for (HashMap<Long, Integer> inner : slopeMap.values()) {
            long S = 0, sumSq = 0;
            for (int c : inner.values()) {
                S += c;
                sumSq += 1L * c * c;
            }
            trapezoidPairs += (S * S - sumSq) / 2;
        }

        long parallelograms = 0;
        for (int cnt : midMap.values()) {
            parallelograms += 1L * cnt * (cnt - 1) / 2;
        }

        long ans = trapezoidPairs - parallelograms;
        return (int) ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
