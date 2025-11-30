import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) {
            total = (total + x) % p; // keep it mod p to avoid overflow
        }

        int need = (int)(total % p);
        if (need == 0) return 0;  // already divisible

        Map<Integer, Integer> lastIndex = new HashMap<>();
        lastIndex.put(0, -1);  // prefix before start

        long prefix = 0;
        int n = nums.length;
        int ans = n;

        for (int i = 0; i < n; i++) {
            prefix = (prefix + nums[i]) % p;
            int cur = (int) prefix;

            int wanted = (cur - need + p) % p;

            if (lastIndex.containsKey(wanted)) {
                int len = i - lastIndex.get(wanted);
                if (len < ans) {
                    ans = len;
                }
            }

            // store latest index for this remainder
            lastIndex.put(cur, i);
        }

        return ans == n ? -1 : ans;
    }
}
