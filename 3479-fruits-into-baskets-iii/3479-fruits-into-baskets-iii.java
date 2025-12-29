class Solution {
    int[] seg;
    int n;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;
        seg = new int[4 * n];
        build(1, 0, n - 1, baskets);

        int unplaced = 0;

        for (int f : fruits) {
            int idx = query(1, 0, n - 1, f);
            if (idx == -1) unplaced++;
            else update(1, 0, n - 1, idx, 0); // mark basket as used
        }

        return unplaced;
    }

    void build(int node, int l, int r, int[] a) {
        if (l == r) {
            seg[node] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(node * 2, l, mid, a);
        build(node * 2 + 1, mid + 1, r, a);
        seg[node] = Math.max(seg[node * 2], seg[node * 2 + 1]);
    }

    int query(int node, int l, int r, int val) {
        if (seg[node] < val) return -1;   // no basket here
        if (l == r) return l;

        int mid = (l + r) / 2;
        int left = query(node * 2, l, mid, val);
        if (left != -1) return left;
        return query(node * 2 + 1, mid + 1, r, val);
    }

    void update( int l, int r, int idx, int val) {
        if (l == r) {
            seg[node] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) update(node * 2, l, mid, idx, val);
        else update(node * 2 + 1, mid + 1, r, idx, val);
        seg[node] = Math.max(seg[node * 2], seg[node * 2 + 1]);
    }
}
