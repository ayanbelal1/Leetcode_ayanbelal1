class Solution {
    public String removeOuterParentheses(String s) {
        
        int n=s.length();

        int open=0;
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(ch=='('){
                open++;

                if(open>1){
                    sb.append('(');
                }
            }
            
            else{
                if(open>1){
                    sb.append(')');
                }
                open--;
            }
        }
        String ans=sb.toString();
        return ans;
    }
}