class Solution {
    public boolean canAliceWin(int n) {
        boolean aliceToMove=false;
        if(n<10){
            return false;
        }
        n-=10;
        int toRemove=9;
        while(n>0){
            if(n<toRemove){
                return !aliceToMove;
            }
            if(aliceToMove){
                aliceToMove=false;
                n-=toRemove;
                toRemove--;
            }
            else{
                n-=toRemove;
                toRemove--;
                aliceToMove=true;
            }
        }
        return !aliceToMove;
    }
}