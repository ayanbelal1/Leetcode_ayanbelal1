class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum=numBottles;
        while(numBottles/numExchange>0){
            int n=numBottles%numExchange;
            numBottles=numBottles/numExchange;
            sum=sum+numBottles;
            numBottles=numBottles+n;

        }
        return sum;
    }
}