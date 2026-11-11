class Solution {
    public long countValidSubstrings(String s) {
        String check="abc";
        int n=s.length();

        long ans=0;
        int start=0;
        for(int end=0;end<n;end++){

            if(end>=2 && s.charAt(end)==check.charAt(2) && s.charAt(end-1)==check.charAt(1) && s.charAt(end-2)==check.charAt(0)){
                start=end-1;
            }
            ans+=(long)end-start+1;
            
        }
        return ans;
    }
}