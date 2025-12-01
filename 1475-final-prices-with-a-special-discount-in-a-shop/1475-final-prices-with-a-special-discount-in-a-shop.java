class Solution {
    public int[] finalPrices(int[] prices) {
        Stack <Integer> st=new Stack<>();
        int[] result=new int[prices.length];
        int i=prices.length-1;
        for (int j=prices.length-1;j>=0;j--){
            while (!st.isEmpty()&&st.peek()>prices[j]){
                st.pop();
            }
            if(st.isEmpty()){
                result[j]=prices[j];
            }
            else {
                result[j]=prices[j]-st.peek();
               
            }
            st.push(prices[j]);
        }
        return result;
    }
}