class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        Deque<Character>st=new ArrayDeque<>();

        int maxSize=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push('(');
                maxSize=Math.max(maxSize,st.size());
            }
            else if(ch==')'){
                st.pop();
            }
        }
        return maxSize;
    }
}