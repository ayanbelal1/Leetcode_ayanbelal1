class Solution {
    public long getDescentPeriods(int[] prices) {
        long count1=prices.length;
        long count2=0;
        int n=prices.length;
        int len = 1;
        for (int i=0;i<n-1;i++){
            if (prices[i]>prices[i+1] && prices[i]-prices[i+1]==1){
                count2=count1;
                count1++;
                
            }
            
        }
        for (int i = 0; i < n - 1; i++) {

            if (prices[i] - prices[i + 1] == 1) {
                len++;   
            } else {
                
                if (len >= 3) {
                    count1 += (len - 2);
                }
                len = 1; 
            }
        }

        
        if (len >= 3) {
            count1 += (len - 2);
        }
        return count1;
    }
}
