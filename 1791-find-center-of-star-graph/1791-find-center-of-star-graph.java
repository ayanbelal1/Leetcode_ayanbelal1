import java.util.*;

class Solution {
    public int findCenter(int[][] edges) {
        int max = 0;
        for (int i = 0; i < edges.length; i++) {
            max = Math.max(max, Math.max(edges[i][0], edges[i][1]));
        }
        List<List<Integer>> ll = new ArrayList<>(max + 1);
        for (int i = 0; i <= max; i++) {
            ll.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1]; 
            ll.get(u).add(v);
            ll.get(v).add(u);
        }
        for (int i = 1; i <= max; i++) {
            if (ll.get(i).size() == max - 1) { 
                return i;
            }
        }

        return -1;
    }
}