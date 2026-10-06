class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();

        if(n==0) return 0;

        if(n==1) return 1;

        int open=0;
        int close=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(ch=='('){
                open++;
                
            }


            if(ch==')'){
                if(open>0){
                    open--;
                }
                else{
                    close++;
                }
            }
        }
        return Math.abs(open+close);
    }
}