class Solution {
    public boolean checkString(String s) {
        int n=s.length();
        boolean hasSeenB=false;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a'){
                if(hasSeenB){
                    return false;
                }
            }
            else{
                hasSeenB=true;
            }
        }
        return true;
    }
}