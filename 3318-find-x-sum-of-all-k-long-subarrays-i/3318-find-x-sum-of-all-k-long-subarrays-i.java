class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i + k <= n; i++) {
            int[] freq = new int[51];  

            for (int j = i; j < i + k; j++) {
                freq[nums[j]]++;
            }

            List<int[]> list = new ArrayList<>();
            for (int v = 1; v <= 50; v++) {
                if (freq[v] > 0) {
                    list.add(new int[]{v, freq[v]});
                }
            }
            Collections.sort(list, (a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1];
                return b[0] - a[0];
            });

            int sum = 0;
            for (int t = 0; t < Math.min(x, list.size()); t++) {
                sum += list.get(t)[0] * list.get(t)[1];
            }

            ans[i] = sum;
        }

        return ans;
    }
}
