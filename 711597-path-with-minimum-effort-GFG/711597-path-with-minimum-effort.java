import java.util.*;

class Solution {

    static class Node implements Comparable<Node> {
        int r, c, cost;
        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public int minCostPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int r = cur.r;
            int c = cur.c;
            int cost = cur.cost;

            if (cost > dist[r][c]) continue;
            if (r == n - 1 && c == m - 1) return cost;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int edge = Math.abs(mat[r][c] - mat[nr][nc]);
                    int newCost = Math.max(cost, edge);

                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.offer(new Node(nr, nc, newCost));
                    }
                }
            }
        }

        return dist[n-1][m-1];
    }
}
