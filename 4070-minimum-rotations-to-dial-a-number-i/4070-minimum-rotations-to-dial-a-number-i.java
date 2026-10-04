class Solution {
    public int minRotations(String s) {
        int n=s.length();

        int currPt=0;
        int sum=0;

        int total=10;

        for(int i=0;i<n;i++){
            
            char ch=s.charAt(i);
            int val=ch-'0';

            if(currPt==val){
                sum+=0;
            }

            else{

                int temp=0;
                if(currPt>val){
                    temp=currPt-val;
                }
                else{
                    temp=val-currPt;
                }
                int diff=Math.min((Math.abs(currPt-val)),10-temp);
                sum+=diff;
                currPt=val;
            }
        }

        return sum;
    }
}