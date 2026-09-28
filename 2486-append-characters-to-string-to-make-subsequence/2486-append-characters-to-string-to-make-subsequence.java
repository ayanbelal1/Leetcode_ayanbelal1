class Solution {
    public int appendCharacters(String s, String t) {
        int i=0;int j=0;
        int n=s.length();
        int m=t.length();
        int count = 0;

        while(i<n && j<m){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }
            else{
                count ++;
                i++;
            }
        }
        return m-(n-count)<0?0:m-(n-count);
    }
}