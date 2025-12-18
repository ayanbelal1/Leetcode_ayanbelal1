class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        
        long baseProfit = 0;
        long[] preA = new long[n + 1]; 
        long[] preB = new long[n + 1]; 
        
        for (int i = 0; i < n; i++) {
            long a = (long) strategy[i] * prices[i];
            baseProfit += a;
            preA[i + 1] = preA[i] + a;
            preB[i + 1] = preB[i] + prices[i];
        }
        
        long maxGain = 0;
        int half = k / 2;
        
        for (int l = 0; l + k <= n; l++) {
            int mid = l + half;
            int r = l + k;
            
            long gain =
                -(preA[mid] - preA[l]) +
                (preB[r] - preB[mid]) -
                (preA[r] - preA[mid]);
            
            maxGain = Math.max(maxGain, gain);
        }
        
        return baseProfit + maxGain;
    }
}
