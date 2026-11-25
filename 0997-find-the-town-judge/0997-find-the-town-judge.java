import java.util.*;

class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> ll = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            ll.add(new ArrayList<>());
        }

        for (int[] t : trust) {
            int u = t[0];
            int v = t[1];
            ll.get(u).add(v);
        }

        for (int i = 1; i <= n; i++) {
            if (ll.get(i).size() == 0) {
                boolean trustedByAll = true;
                for (int x = 1; x <= n; x++) {
                    if (x != i && !ll.get(x).contains(i)) {
                        trustedByAll = false;
                        break;
                    }
                }
                if (trustedByAll) {
                    return i;
                }
            }
        }

        return -1;
    }
}