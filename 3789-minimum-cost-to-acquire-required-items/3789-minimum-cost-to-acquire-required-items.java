class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long both=(long)need1*cost1+(long)need2*cost2;

        long middle=Math.min(need1,need2);

        long either=middle*costBoth;
        either +=(long)(need1-middle)*cost1;
        either +=(long)(need2-middle)*cost2;

        long com =(long)Math.max(need1,need2)*costBoth;

        return Math.min(both,Math.min(either,com));
    }
}