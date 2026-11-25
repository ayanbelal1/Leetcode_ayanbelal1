class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        TreeMap<Integer, Integer> inDeg = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inDeg.put(i, 0);
        }
        for (List<Integer> ll : edges) {
            inDeg.put(ll.get(1), inDeg.get(ll.get(1)) + 1);
        }
        for (int x : inDeg.keySet()) {
            if (inDeg.getOrDefault(x, 0) == 0) {
                ans.add(x);
            }
        }
        
        return ans;
    }
}