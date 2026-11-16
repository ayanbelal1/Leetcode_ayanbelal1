class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb=new StringBuilder(s);
        int n=sb.length();

        while(n>k){
            StringBuilder temp=new StringBuilder();
            for(int i=0;i<n;i=i+k){
                int sum=0;
                for(int j=i;j<i+k;j++){
                    if(j<n) sum+=sb.charAt(j)-'0';
                }
                temp.append(sum);
            }
            sb=temp;
            n=sb.length();
        }
        return sb.toString();
    }
}