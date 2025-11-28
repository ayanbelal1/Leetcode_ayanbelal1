class Solution {
    private int components;
    private int k;
    private int[] values;
    private List<Integer>[] graph;
    private boolean[] visited;
    
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        this.values = values;
        this.components = 0;
        
        // Build adjacency list
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        visited = new boolean[n];
        
        long rootRem = dfs(0);
        
        // Root subtree is also divisible by k (given total sum divisible by k)
        // so it forms one more component
        components++;
        
        return components;
    }
    
    // DFS returns subtree sum mod k
    private long dfs(int u) {
        visited[u] = true;
        
        long sum = values[u];  // use long to prevent overflow
        
        for (int v : graph[u]) {
            if (!visited[v]) {
                long childRem = dfs(v);
                if (childRem % k == 0) {
                    // Child subtree forms its own k-divisible component
                    components++;
                } else {
                    // Merge remainder into this node's subtree
                    sum += childRem;
                }
            }
        }
        
        return sum % k;
    }
}
