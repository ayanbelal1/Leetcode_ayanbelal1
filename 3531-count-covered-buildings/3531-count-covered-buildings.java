public class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int m = buildings.length;
        int[] minY = new int[n+1];
        int[] maxY = new int[n+1];
        int[] minX = new int[n+1];
        int[] maxX = new int[n+1];

        Arrays.fill(minY, Integer.MAX_VALUE);
        Arrays.fill(maxY, Integer.MIN_VALUE);
        Arrays.fill(minX, Integer.MAX_VALUE);
        Arrays.fill(maxX, Integer.MIN_VALUE);

        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            if (y < minY[x]) minY[x] = y;
            if (y > maxY[x]) maxY[x] = y;
            if (x < minX[y]) minX[y] = x;
            if (x > maxX[y]) maxX[y] = x;
        }

        int count = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            if (minY[x] < y && y < maxY[x] && minX[y] < x && x < maxX[y]) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countCoveredBuildings(3, new int[][]{{1,2},{2,2},{3,2},{2,1},{2,3}})); 
        System.out.println(sol.countCoveredBuildings(3, new int[][]{{1,1},{1,2},{2,1},{2,2}})); 
        System.out.println(sol.countCoveredBuildings(5, new int[][]{{1,3},{3,2},{3,3},{3,5},{5,3}})); 
    }
}
